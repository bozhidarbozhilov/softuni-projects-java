package genericCount;

import java.util.List;

public class CompBox<T extends Comparable> {
    private T element;

    public CompBox() {
    }

    public T getElement(){
        return this.element;
    }
    public void setElement(T element){
        this.element = element;
    }

    public int compareTo(CompBox<T> other){
        return this.element.compareTo(other.element);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.element.getClass().getName())
                .append(": ")
                .append(element);

        return output.toString();
    }
}


