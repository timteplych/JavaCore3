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
public class CheckArrayTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] testData = {
                {new int[]{4,5,1,4,1,1,1,4,7},false},
                {new int[]{1,1,1,1,1,4,4,4,4,1,4,4},true},
                {new int[]{4,4,4,4,4,4,1,1,1,4,4},true},
                {new int[]{7,7,7,7,7,7,7,6,5,6,2,3,8444,1},false}
        };
        return Arrays.asList(testData);
    }

    private int[] masIn;
    private boolean checked;

    public CheckArrayTest(int[] masIn, boolean checked) {
        this.masIn = masIn;
        this.checked = checked;
    }

    private ArrayProcessing arrayProcessing;
    @Before
    public void startTest(){
        arrayProcessing = new ArrayProcessing();
    }
    @Test
    public void testCheckArray(){
        Assert.assertEquals(checked,arrayProcessing.checkArray(masIn));
    }
}
