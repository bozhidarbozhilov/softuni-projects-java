package database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IntegerDatabaseTests {
    private static final Integer[] TEST_ARRAY = new Integer[]{1,3,4,4,4,3,44,4,4,0,9,4};
    private static final Integer[] ADD_ARRAY = new Integer[]{1,3,4,4,4,3,44,4,4,0,9,4,5};
    private static final Integer ELEMENT_TO_ADD = 5;
    private Integer[] illegalArray;
    private Database testDatabase;

    @Before
    public void initializeTestDatabase() throws OperationNotSupportedException {
        testDatabase = new DatabaseImpl(TEST_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIllegalWithBiggerLengthConstructor() throws OperationNotSupportedException {
        this.illegalArray = new Integer[17];
        Database db = new DatabaseImpl(this.illegalArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIllegalWithSmallerLengthConstructor() throws OperationNotSupportedException {
        this.illegalArray = new Integer[0];
        Database db = new DatabaseImpl(this.illegalArray);
    }

    @Test
    public void testLegalConstructor() throws OperationNotSupportedException {

        Assert.assertArrayEquals(TEST_ARRAY, testDatabase.getElements());
    }

    @Test
    public void testAddFunction() throws OperationNotSupportedException {
        testDatabase.add(ELEMENT_TO_ADD);

        Assert.assertArrayEquals(ADD_ARRAY, testDatabase.getElements());
    }

    @Test
    public void testRemoveFunction() throws OperationNotSupportedException {
        Database addedDatabase = new DatabaseImpl(ADD_ARRAY);
        addedDatabase.remove();
        Assert.assertArrayEquals(TEST_ARRAY, addedDatabase.getElements());
    }

    @Test
    public void testGetElementsFunction(){
        Assert.assertArrayEquals(TEST_ARRAY, testDatabase.getElements());
    }
}
