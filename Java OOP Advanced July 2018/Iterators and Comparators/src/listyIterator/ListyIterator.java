package listyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<String> implements Iterable<String>{
    int index;
    List<String> strings;
    Iterator<String> listIter;

    public ListyIterator(String... strings) {
        this.index = 0;
        this.setStrings(strings);
    }

    private final class ListyIter implements Iterator<String>{
        private int innerIndex;

        public ListyIter() {
            this.innerIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.innerIndex <= strings.size()-1;
        }

        @Override
        public String next() {
            return strings.get(this.innerIndex++);
        }
    }

    private void setStrings(String... strings) {
        this.strings = Arrays.asList(strings);
    }

    public boolean move(){
        if(this.hasNext()){
            this.index++;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        return this.index < this.strings.size()-1;
    }

    public void print(){
        if(this.strings.isEmpty()){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        System.out.println(this.strings.get(this.index));
    }

    public void printAll(ListyIterator<String> toIter){
        StringBuilder sb = new StringBuilder();
        for (String string :toIter) {
            sb.append(string).append(" ");
        }
        System.out.println(sb.toString());
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIter();
    }

}
