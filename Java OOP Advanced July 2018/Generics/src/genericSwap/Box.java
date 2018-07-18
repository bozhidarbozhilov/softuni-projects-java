package genericSwap;

import java.util.List;

public class Box<T> {
    T element;

    public Box(T element) {
        this.element = element;
    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
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

