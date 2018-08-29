package database;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseImpl<T> implements Database<T> {
    private static final String ERROR_MESSAGE = "Operation is not supported!";
    private static final int ARRAY_SIZE = 16;
    private T[] elements;
    private int index;

    public DatabaseImpl(T... integers) throws OperationNotSupportedException {
        this.setArray(integers);
        this.index = integers.length - 1;
    }

    private void setArray(T... integers) throws OperationNotSupportedException {
        if(integers.length > 16 || integers.length<1){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        this.elements = (T[]) new Object[ARRAY_SIZE];
        for (int i = 0; i < integers.length; i++) {
            this.elements[i] = integers[i];
        }
    }

    public void add(T element) throws OperationNotSupportedException {
        if (this.index == 16 || ((Person) element).getId() < 0 || this.isContainId(((Person) element).getId())) {
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        this.elements[++this.index] = element;
    }

    public void remove() throws OperationNotSupportedException {
        if(this.elements.length==0){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }

        this.elements[this.index--] = null;
    }

    public T[] getElements() {
        T[] notNullElements = (T[])new Object[this.index+1];
        for (int i = 0; i < this.elements.length; i++) {
            if(this.elements[i] != null){
                notNullElements[i] = this.elements[i];
            }

        }
        return notNullElements;
    }

    public T findById(Person person) throws OperationNotSupportedException {
        if(person==null){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        T toReturn = null;
        for (int i = 0; i<this.index; i++) {
            if(((Person) this.elements[i]).getId().equals(person.getId())){
                toReturn = this.elements[i];
                break;
            }
        }
        if(toReturn == null){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        return toReturn;
    }

    public T findByUserName(Person person) throws OperationNotSupportedException {
        if(person==null){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        T toReturn = null;
        for (int i = 0; i<this.index; i++) {
            if(((Person) this.elements[i]).getName().equals(person.getName())){
                toReturn = this.elements[i];
                break;
            }
        }
        if(toReturn == null){
            throw new OperationNotSupportedException(ERROR_MESSAGE);
        }
        return toReturn;
    }

    private boolean isContainId(int id){
        for (int i = 0; i<this.index; i++) {
            if(((Person)this.elements[i]).getId() == id){
                return true;
            }
        }
        return false;
    }

}
