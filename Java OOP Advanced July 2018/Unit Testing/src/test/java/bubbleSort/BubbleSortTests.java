package bubbleSort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTests {
    private static final Integer[] SORTED_INTEGER_ARRAY = {1, 2, 3, 4, 5, 6, 7};
    private static final Integer[] TEST_INTEGER_ARRAY = {1, 6, 7, 4, 2, 5, 3};
    private static final String[] TEST_STRING_ARRAY = {"B", "A", "D", "C"};
    private static final String[] SORTED_STRING_ARRAY = {"A", "B", "C", "D"};
    private static final Integer[] SORTED_INTEGER_ARRAY_WITH_NULL_ELEMENTS = {1, 2, 3, 4, 5};
    private static final Integer[] TEST_INTEGER_ARRAY_WITH_NULL_ELEMENTS = {1, null, 4, null, 2, 5, 3};

    private Bubble bubble;

    @Test
    public void testIntegerSorting(){
        this.bubble = new Bubble<Integer>(TEST_INTEGER_ARRAY);
        this.bubble.sort();
        Assert.assertEquals(Arrays.toString(SORTED_INTEGER_ARRAY), Arrays.toString(this.bubble.getElements()));

    }

    @Test
    public void sortOneElementArray(){
        this.bubble =new Bubble<Integer>(3);
        this.bubble.sort();
        String expectedValue = "[3]";
        Assert.assertEquals(expectedValue, Arrays.toString(this.bubble.getElements()));
    }

    @Test
    public void sortStringArray(){
        this.bubble = new Bubble<String>(TEST_STRING_ARRAY);
        this.bubble.sort();
        Assert.assertEquals(Arrays.toString((SORTED_STRING_ARRAY)), Arrays.toString(this.bubble.getElements()));
    }

    @Test
    public void sortArrayWithNullElementsInIt(){
        this.bubble = new Bubble<Integer>(TEST_INTEGER_ARRAY_WITH_NULL_ELEMENTS);
        this.bubble.sort();
        String expectedValue = "[1, 2, 3, 4, 5, null, null]";
        Assert.assertEquals(expectedValue, Arrays.toString(this.bubble.getElements()));
    }
}
