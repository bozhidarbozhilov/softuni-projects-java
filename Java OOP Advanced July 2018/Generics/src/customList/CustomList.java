package customList;

import java.util.Comparator;
import java.util.List;

public interface CustomList<T extends Comparable<T>>{
    void add(T element);
 	T remove(int index);
 	boolean contains(T element);
 	void swap(int index1, int index2);
 	int countGreaterThan(T element);
 	T getMax();
 	T getMin();
 	Iterable<T> getElements();
}
