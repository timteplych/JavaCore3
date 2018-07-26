package ru.ttv.javacore3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ttv.javacore3.lesson6.ArrayProcessing;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetSubArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] testData = {
                {new int[]{ 1, 2, 4, 4, 2, 3, 4, 1, 7},new int[]{1, 7}},
                {new int[]{ 1, 2, 4, 4, 2, 3, 5, 1, 7},new int[]{ 2, 3, 5, 1, 7}},
                {new int[]{ 1, 2, 4, 1, 2, 3, 1, 1, 7},new int[]{ 1, 2, 3, 1, 1, 7}}
        };
        return Arrays.asList(testData);
    }
    private int[] masIn;
    private int[] masOut;

    public GetSubArrayTest(int[] masIn, int[] masOut) {
        this.masIn = masIn;
        this.masOut = masOut;
    }

    private ArrayProcessing arrayProcessing;
    @Before
    public void startTest(){
        arrayProcessing = new ArrayProcessing();
    }
    @Test
    public void testGetSubArray(){
        Assert.assertArrayEquals(masOut,arrayProcessing.getSubArray(masIn));
    }

}
