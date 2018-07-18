package customList;

import java.util.ArrayList;
import java.util.List;

public class MyCustomList<T extends Comparable<T>> implements CustomList<T> {
    private List<T> myList;

    public MyCustomList(){
        this.myList = new ArrayList<>();
    }

    private boolean isValidIndex(int index){
        return index>=0 && index<this.myList.size();
    }

    @Override
    public void add(T element) {
        this.myList.add(element);
    }

    @Override
    public T remove(int index) {
        if(isValidIndex(index)){
            return this.myList.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        for (T item : myList) {
            if(item.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void swap(int index1, int index2) {
        if(isValidIndex(index1) && isValidIndex(index2)){
            T temp = this.myList.get(index1);
            this.myList.set(index1, this.myList.get(index2));
            this.myList.set(index2, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        int counter = 0;
        for (T item : this.myList) {
            if(item.compareTo(element)>0){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public T getMax() {
        T max = this.myList.get(0);
        for (T item : myList) {
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = this.myList.get(0);
        for (T item : myList) {
            if(item.compareTo(min)<0){
                min = item;
            }
        }
        return min;
    }

    @Override
    public Iterable<T> getElements() {
        return this.myList;
    }

    public int getSize(){
        return this.myList.size();
    }

    public T getElement(int index){
        if(isValidIndex(index)){
            return this.myList.get(index);
        }
        return null;
    }

}
