package stackIterator;

import java.util.*;

public class CustomStack<Integer> implements Iterable<Integer> {
    private List<Integer> elements;
    private int index;

    public CustomStack() {
        this.elements = new ArrayList<>();
        this.index = 0;
    }

    public void push(Integer integer){
        this.elements.add(0, integer);
    }

    public Integer pop(){
        if(this.elements.isEmpty()){
            throw new NoSuchElementException("No elements");
        }
        return this.elements.remove(0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }
    private final class MyIterator implements Iterator<Integer>{
        int cursor;

        public MyIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor<=elements.size()-1;
        }

        @Override
        public Integer next() {
            return elements.get(this.cursor++);
        }
    }
}
