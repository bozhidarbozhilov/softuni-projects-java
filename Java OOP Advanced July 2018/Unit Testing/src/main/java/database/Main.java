package database;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) {
        try {
            Person[] people = GeneratePeople.generatePeople(16);
            DatabaseImpl<Person> db = new DatabaseImpl<Person>(people);
            //db.add(6);
            String debug = "";
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
