package froggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> numbers;
    private boolean hitTheEnd;

    public Lake() {
        this.numbers = new ArrayList<>();
        this.hitTheEnd = false;
    }

    public void addElements(List<T> elements) {
        this.numbers.addAll(elements);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private int cursor;

        public Frog() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = this.cursor < numbers.size();
            if(hitTheEnd && !hasNext){
                return false;
            }
            if(!hasNext){
                if(numbers.size() == 1){
                    return false;
                }
                hitTheEnd =  true;
                this.cursor = 1;
            }

            return true;
        }

        @Override
        public T next() {
            T toReturn  = numbers.get(this.cursor);
            this.cursor +=2;
            return toReturn;
        }
    }
}
