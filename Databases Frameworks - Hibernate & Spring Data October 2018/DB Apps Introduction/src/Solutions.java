import Contracts.Writable;
import Contracts.Readable;

import java.sql.*;
import java.util.*;

public class Solutions {
    private Connection connection;
    private Writable writer;
    private Readable reader;

    public Solutions(Connection connection, Writable writer, Readable reader) {
        this.connection = connection;
        this.writer = writer;
        this.reader = reader;
    }

    public void p01_GetVillainsNames() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT v.name AS 'name', COUNT(mv.minion_id) AS 'minions_count'\n" +
                        "FROM villains v\n" +
                        "       INNER JOIN minions_villains mv ON v.id = mv.villain_id\n" +
                        "GROUP BY v.name\n" +
                        "HAVING minions_count > 3\n" +
                        "ORDER BY minions_count DESC;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            this.writer.writeLine(resultSet.getString("name") + " "
                    + resultSet.getLong("minions_count"));
        }
    }

    public void p02_GetMinionNames() throws SQLException {
        PreparedStatement getVillainName = this.connection.prepareStatement(
                "SELECT v.name FROM villains v where v.id=?;");
        this.writer.write("Enter villain id: ");
        int villainId = Integer.parseInt(this.reader.readLine());
        getVillainName.setInt(1, villainId);

        PreparedStatement getMinions = this.connection.prepareStatement(
                "SELECT v.name as 'villain_name', m.name as 'minion_name'," +
                        " m.age as 'minion_age'\n" +
                        "FROM minions m\n" +
                        "INNER JOIN minions_villains m2 on m.id = m2.minion_id\n" +
                        "INNER JOIN villains v on v.id = m2.villain_id and v.id = ?;");

        getMinions.setInt(1, villainId);

        ResultSet villainNameResult = getVillainName.executeQuery();

        String villainName = villainNameResult.first() ?
                villainNameResult.getString("name") :
                "No villain with ID " + villainId + " exists in the database.";
        Map<String, Integer> minions = new LinkedHashMap<>();

        ResultSet minionsResult = getMinions.executeQuery();
        while (minionsResult.next()) {
            minions.put(minionsResult.getString("minion_name"),
                    minionsResult.getInt("minion_age"));
        }

        writer.writeLine("Villain: " + villainName);
        if (!villainName.equals
                ("No villain with ID " + villainId + " exists in the database.")) {
            if (!minions.isEmpty()) {
                for (Map.Entry<String, Integer> minion : minions.entrySet()) {
                    this.writer.writeLine(minion.getKey() + " " + minion.getValue());
                }
            } else {
                this.writer.writeLine("<no minions>");
            }
        }

    }

    public void p03_addMinion() throws SQLException {
        this.writer.writeLine("Enter minion and villain details: ");
        String[] minionDetails = this.reader.readLine().split("\\s+");
        String[] villainDetails = this.reader.readLine().split("\\s+");

        String minionName = minionDetails[1];
        int minionAge = Integer.parseInt(minionDetails[2]);
        String minionTown = minionDetails[3];
        String villainName = villainDetails[1];

        PreparedStatement townCheck = this.connection.prepareStatement(
                "SELECT t.id FROM towns t WHERE t.name = ?");
        townCheck.setString(1, minionTown);
        ResultSet townCheckResult = townCheck.executeQuery();
        if (!townCheckResult.first()) {
            PreparedStatement insertTown = this.connection.prepareStatement(
                    "INSERT INTO towns(`name`)" +
                            "VALUES (?)");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();
            this.writer.writeLine("Town " + minionTown + " was added to the database.");
        }

        ResultSet getTownIdResult = townCheck.executeQuery();
        int town_id = getTownIdResult.first() ? getTownIdResult.getInt("id") : Integer.MIN_VALUE;

        PreparedStatement checkVillain = this.connection.prepareStatement(
                "SELECT v.id FROM villains v WHERE v.name = ?");
        checkVillain.setString(1, villainName);
        ResultSet checkVillainResult = checkVillain.executeQuery();
        if (!checkVillainResult.first()) {
            PreparedStatement insertVillain = this.connection.prepareStatement(
                    "INSERT INTO villains(`name`, `evilness_factor`)" +
                            "VALUES (?, 'evil')");
            insertVillain.setString(1, villainName);
            insertVillain.executeUpdate();
            this.writer.writeLine("Villain " + villainName + " was added to the database.");
        }
        ResultSet getVillainId = checkVillain.executeQuery();
        int villandId = getVillainId.first()?getVillainId.getInt("id"):Integer.MIN_VALUE;

        PreparedStatement insertMinion = this.connection.prepareStatement(
                "INSERT INTO minions(`name`, `age`, `town_id`)" +
                        "VALUES (?,?,?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, town_id);
        insertMinion.executeUpdate();

        PreparedStatement getMinionId = this.connection.prepareStatement(
                "SELECT m.id FROM minions m WHERE m.name = ?");
        getMinionId.setString(1, minionName);

        ResultSet getMinionIdResult = getMinionId.executeQuery();
        int minionId = getMinionIdResult.first()?getMinionIdResult.getInt("id"):Integer.MIN_VALUE;

        PreparedStatement assignMinionToVillain = this.connection.prepareStatement(
                "INSERT INTO minions_villains(`minion_id`, `villain_id`)" +
                        "VALUES (?,?)");
        assignMinionToVillain.setInt(1,minionId);
        assignMinionToVillain.setInt(2,villandId);
        assignMinionToVillain.executeUpdate();
        this.writer.writeLine("Successfully added "+minionName+" to be minion of "+villainName+".");

    }

    public void p04_ChangeTownsNamesCasing() throws SQLException {
        PreparedStatement getTownsInCountry = this.connection.prepareStatement(
                "UPDATE towns t SET t.name = Upper(t.name) WHERE t.country =?;");
        this.writer.write("Enter country for search: ");
        String country = this.reader.readLine();
        getTownsInCountry.setString(1, country);
        int rowsAffected = getTownsInCountry.executeUpdate();

        PreparedStatement getUpperCaseTowns = this.connection.prepareStatement(
                "SELECT t.name FROM towns t WHERE t.country = ?;");
        getUpperCaseTowns.setString(1,country);
        ResultSet getUpperCaseTownsResult = getUpperCaseTowns.executeQuery();
        List<String> towns = new ArrayList<>();
        while(getUpperCaseTownsResult.next()) {
            towns.add(getUpperCaseTownsResult.getString("name"));
        }

        if(rowsAffected != 0){
            this.writer.writeLine(rowsAffected+ " town names were affected.");
            this.writer.writeLine(towns.toString());
        }else{
            this.writer.writeLine("No town names were affected.");
        }
    }

    public void p05_RemoveVillain() throws SQLException {
        this.writer.write("Enter villain id which want to remove: ");
        int idForRemove = Integer.parseInt(this.reader.readLine());
        String villainName = "";

        PreparedStatement checkForExistingVillain =
                this.connection.prepareStatement(
                        "SELECT v.name, COUNT(v.id) AS 'count' FROM villains v WHERE v.id = ?;");
        checkForExistingVillain.setInt(1,idForRemove);
        ResultSet checkResult = checkForExistingVillain.executeQuery();

        int villainCount = checkResult.first()?checkResult.getInt("count")
                :0;

        villainName = checkResult.getString("name");
        int deletedMinions = Integer.MIN_VALUE;
        if(villainCount == 0){
            writer.writeLine("No such villain was found");
            return;
        }
        PreparedStatement releaseMinions = this.connection.prepareStatement(
                "DELETE FROM minions_villains WHERE villain_id = ?;");
        releaseMinions.setInt(1, idForRemove);
        int removedMinions = releaseMinions.executeUpdate();

        PreparedStatement deleteVillain = this.connection.prepareStatement(
                "DELETE FROM villains WHERE id = ?;");
        deleteVillain.setInt(1, idForRemove);
        int deletedVillain = deleteVillain.executeUpdate();

        this.writer.writeLine(villainName + " was deleted");
        this.writer.writeLine(removedMinions + " minions released");
    }

    public void p06_PrintAllMinionNames() throws SQLException {
        PreparedStatement getAllMinions = this.connection.prepareStatement(
                "SELECT m.name FROM minions m ORDER BY m.id;");
        ResultSet allMinionsResult = getAllMinions.executeQuery();
        List<String> minions = new ArrayList<>();

        while(allMinionsResult.next()){
            minions.add(allMinionsResult.getString("name"));
        }

        for (int i = 0; i < minions.size()/2; i++) {
            this.writer.writeLine(minions.get(i));
            this.writer.writeLine(minions.get(minions.size()-1-i));
        }
    }

    public void p07_IncreaseMinionsAge() throws SQLException {
        this.writer.write("Enter ids for minions who want to increase age: ");
        int[] minionIds = Arrays.stream(this.reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        StringBuilder prepareQuery = new StringBuilder();
        for (int i = 0; i < minionIds.length; i++) {
            prepareQuery.append("?, ");
        }
        prepareQuery.deleteCharAt(prepareQuery.length()-1);
        prepareQuery.deleteCharAt(prepareQuery.length()-1);

        String sqlStatementForAgeIncrese =
                "UPDATE minions m SET m.age = m.age + 1 WHERE m.id IN ("+prepareQuery.toString()+");";
        String sqlStatementForNamesToLowerCase =
                "UPDATE minions m SET m.name = LOWER(m.name) WHERE m.id NOT IN ("+prepareQuery.toString()+");";


        PreparedStatement updateMinionsAge = this.connection.prepareStatement(sqlStatementForAgeIncrese);

        PreparedStatement namesToLowerCase = this.connection.prepareStatement(sqlStatementForNamesToLowerCase);
        for (int i = 0; i < minionIds.length; i++) {
            updateMinionsAge.setInt(i+1, minionIds[i]);
            namesToLowerCase.setInt(i+1, minionIds[i]);
        }

        int updatedMinions = updateMinionsAge.executeUpdate();
        namesToLowerCase.executeUpdate();

        PreparedStatement viewAllMinions = this.connection.prepareStatement(
                "SELECT * FROM minions");
        ResultSet allMinions = viewAllMinions.executeQuery();
        while(allMinions.next()){
            this.writer.writeLine(allMinions.getInt("id") +" "+allMinions.getString("name")
            +" "+ allMinions.getInt("age"));
        }
    }

    public void p08_IncreaseAgeStoredProcedure() throws SQLException {
        this.writer.write("Enter minion id to increase him age: ");
        int minionId = Integer.parseInt(this.reader.readLine());
        CallableStatement callProcedureForIncreaseAge = this.connection.prepareCall(
                "CALL usp_get_older(?);");
        callProcedureForIncreaseAge.setInt(1, minionId);
        callProcedureForIncreaseAge.executeUpdate();
        PreparedStatement getMinionsData = this.connection.prepareStatement(
                "SELECT m.name, m.age FROM minions m WHERE m.id = ?;");
        getMinionsData.setInt(1, minionId);
        ResultSet minionsData = getMinionsData.executeQuery();

        if(minionsData.next()){
            this.writer.writeLine(minionsData.getString("name") + " " +
                    minionsData.getInt("age"));
        }
    }

}
