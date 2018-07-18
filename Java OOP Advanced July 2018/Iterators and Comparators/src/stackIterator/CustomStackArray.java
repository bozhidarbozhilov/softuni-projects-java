package stackIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStackArray<T> implements Iterable<T> {
    private static final int INITIAL_STACK_CAPACITY = 16;
    private static final String EMPTY_STACK_MESSAGE = "No elements";
    private int index;
    private T[] elements;
    private int currentCapacity = INITIAL_STACK_CAPACITY;

    public CustomStackArray() {
        this.index = 0;
        this.elements = (T[]) new Object[INITIAL_STACK_CAPACITY];
    }

    public void push(T element){
        if(hasCapcity()){
            this.elements[index++] = element;
        }else{
            doubleCapacity();
            this.elements[index++] = element;
        }

    }

    public T pop(){
        if(this.index-1 < 0){
            throw new NoSuchElementException(EMPTY_STACK_MESSAGE);
        }
        T toPop = this.elements[this.index-1];
        this.elements[--this.index] = null;
        return toPop;
    }

    private boolean hasCapcity(){
        return this.index <= currentCapacity;
    }
    private T[] doubleCapacity(){
        currentCapacity = currentCapacity * 2;
        return this.elements = Arrays.copyOf(elements, currentCapacity);

    }

    @Override
    public Iterator<T> iterator() {
        return new CustIterator();
    }

    private final class CustIterator implements Iterator<T>{
        int cursor;

        public CustIterator() {
            this.cursor = index;
        }

        @Override
        public boolean hasNext() {
            return this.cursor > 0;
        }

        @Override
        public T next() {
            return elements[--cursor];
        }
    }

}
