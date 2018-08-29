package bubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bubble<T extends Comparable<T>> {
    private T[] elements;
    private T[] allSortedElements;


    public Bubble(T... elements){
        this.setElements(elements);
    }

    public void setElements(T... elements) {
        this.elements=elements;
    }

    public T[] getElements() {
        return this.elements;
    }

    public void sort(){
         List<T> notNullElements =new ArrayList<T>();
        List<T> nullElements = new ArrayList<T>();
        for (T element : this.elements) {
            if(element == null){
                nullElements.add(null);
            }else{
                notNullElements.add(element);
            }
        }
        for (int i = 0; i < notNullElements.size(); i++)
            for (int j = i+1; j < notNullElements.size(); j++) {
                if(notNullElements.get(i).compareTo(notNullElements.get(j))>0){
                    T temp = notNullElements.get(i);
                    notNullElements.set(i,notNullElements.get(j));
                    notNullElements.set(j,temp);
                }
        }
        if(!nullElements.isEmpty()){
            notNullElements.addAll(nullElements);
        }

        //this.allSortedElements = (T[]) new Object[this.elements.length];

        for (int i = 0; i < notNullElements.size(); i++) {
            this.elements[i] = notNullElements.get(i);
        }
    }
}
