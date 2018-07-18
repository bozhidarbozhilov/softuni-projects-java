package customList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(MyCustomList<T> myList){
        int n = myList.getSize();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (myList.getElement(j).compareTo(myList.getElement(j+1))>0)
                {
                    myList.swap(j, j+1);
                }

    }
}
