package strategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    public AgeComparator() {
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
