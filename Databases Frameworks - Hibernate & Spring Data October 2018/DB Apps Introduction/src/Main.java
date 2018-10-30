import Contracts.Readable;
import Contracts.Writable;
import io.ConsoleReader;
import io.ConsoleWriter;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static Readable reader;
    static Writable writer;
    static Connection connection;
    static Solutions solution;
    public static void main(String[] args) throws SQLException {
        scanner = new Scanner(System.in);
        reader = new ConsoleReader(scanner);
        writer = new ConsoleWriter();

        String user = "";
        writer.write("Enter username (default root): ");
        user = scanner.nextLine();
        user = user.isEmpty() ? "root" : user;

        String password = "";
        System.out.print("Enter password (default empty): ");
        password = scanner.nextLine();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        String portToConnect = "";
        System.out.print("Enter port number (default 3306): ");
        portToConnect = scanner.nextLine();
        portToConnect = portToConnect.isEmpty()?"3306":portToConnect;
        String connectionString = "jdbc:mysql://localhost:"+portToConnect+"/minions_db";

        connection = DriverManager.getConnection(connectionString, props);
        solution = new Solutions(connection, writer, reader);
        printProblems();
        int choiceNumber = Integer.parseInt(reader.readLine());
        chooseProblem(choiceNumber);
    }

    private static void chooseProblem(int choiceNumber) {
        switch (choiceNumber){
            case 1:
                try{
                    solution.p01_GetVillainsNames();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 2:
                try{
                    solution.p02_GetMinionNames();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 3:
                try{
                    solution.p03_addMinion();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;

            case 4:
                try{
                    solution.p04_ChangeTownsNamesCasing();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 5:
                try{
                    solution.p05_RemoveVillain();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 6:
                try{
                    solution.p06_PrintAllMinionNames();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 7:
                try{
                    solution.p07_IncreaseMinionsAge();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
            case 8:
                try{
                    solution.p08_IncreaseAgeStoredProcedure();
                }catch (Exception e){
                    writer.writeLine(e.getMessage());
                }
                break;
        }
    }

    private static void printProblems() {
        writer.writeLine("Solutions for DB Apps Introduction Problems:");
        writer.writeLine("  1. Get villains' names.");
        writer.writeLine("  2. Get minion names.");
        writer.writeLine("  3. Add minion.");
        writer.writeLine("  4. Change towns name casing.");
        writer.writeLine("  5. Remove villain.");
        writer.writeLine("  6. Print all minion names.");
        writer.writeLine("  7. Increase minions age.");
        writer.writeLine("  8. Increase age stored procedure.");
        writer.write("Enter the problem number you want to see (from 1 to 8): ");

    }
}
