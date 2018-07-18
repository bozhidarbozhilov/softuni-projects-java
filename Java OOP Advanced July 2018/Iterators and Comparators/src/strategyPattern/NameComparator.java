package strategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    public NameComparator() {
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getName().length()-o2.getName().length()==0){
            return o1.getName().toLowerCase().charAt(0) - o2.getName().toLowerCase().charAt(0);
        }
        return o1.getName().length()-o2.getName().length();
    }
}
