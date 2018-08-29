package listIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListIterator {
    private static final String ERROR_MESSAGE = "Invalid Operation!";
    private int currentIndex;
    private List<String> elements;

    public CustomListIterator(String... elements) throws OperationNotSupportedException {
        this.currentIndex = 0;
        this.elements = new ArrayList<String>();
        this.setElements(elements);
    }

    public void setElements(String... elements) throws OperationNotSupportedException {
        for (String element : elements) {
            if(element == null){
                throw new OperationNotSupportedException(ERROR_MESSAGE);
            }
        }
        this.elements = Arrays.asList(elements);
    }

    public List<String> getElements() {
        return this.elements;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean move(){
        if(!this.hasNext()){
            return false;
        }
        this.currentIndex++;
        return true;
    }
    public boolean hasNext(){
        return this.currentIndex < this.elements.size()-1;
    }

    public String print() throws OperationNotSupportedException {
        if(this.elements.isEmpty()){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        return this.elements.get(this.currentIndex);

    }
}
