package genericBox;

public class Box<T> {
    T element;

    public Box(T element){
        this.element = element;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.element.getClass().getName())
                .append(": ")
                .append(element);

        return  output.toString();
    }
}
