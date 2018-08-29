package listIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class ListIteratorTests {
    private static final String[] TEST_STRING_ARRAY = new String[]{"Ivan", "Dragan", "Pesho", "Gosho", "Sofia"};
    private CustomListIterator testList;


    @Before
    public void initializeTestObject() throws OperationNotSupportedException {
        this.testList = new CustomListIterator(TEST_STRING_ARRAY);
    }

    @Test
    public void createObjectListIterator() {
        Assert.assertEquals(Arrays.asList(TEST_STRING_ARRAY), this.testList.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createInstanceWithNullElements() throws OperationNotSupportedException {
        this.testList = new CustomListIterator("Ivan", "Dragan", "Pesho", "Gosho", "Sofia", null);
    }

    @Test
    public void moveCommand(){
        this.testList.move();
        this.testList.move();
        Assert.assertEquals(2, this.testList.getCurrentIndex());
    }

    @Test
    public void moveCommandAtTheEndOfTheList(){
        this.testList.setCurrentIndex(TEST_STRING_ARRAY.length);

        Assert.assertFalse(this.testList.move());
    }

    @Test
    public void hasNextCommand(){
        Assert.assertTrue(this.testList.hasNext());
    }

    @Test
    public void falseHasNext() {
        this.testList.setCurrentIndex(TEST_STRING_ARRAY.length-1);
        Assert.assertFalse(this.testList.hasNext());
    }

    @Test
    public void printFunction() throws OperationNotSupportedException {
        Assert.assertEquals("Ivan", this.testList.print());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void printEmptyCollection() throws OperationNotSupportedException {
        this.testList = new CustomListIterator();
        this.testList.print();
    }
}
