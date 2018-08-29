package database;

public class GeneratePeople {
    public static Person[] generatePeople(int size) {
        Person[] people = new Person[size];

        for (int i = 0; i < size; i++) {
            people[i] = new Person(i,"Pesho" + i);

        }
        return people;
    }
}
