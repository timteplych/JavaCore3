package ru.ttv.javacore3;

import org.junit.Assert;
import org.junit.Test;
import ru.ttv.javacore3.lesson6.App;

public class AppTestLesson6 {
    private App app;
    @Test
    public void testGetSubArray(){
        app = new App();
        int[] masIn = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] masOut = {1, 7};
        Assert.assertArrayEquals(masOut,App.getSubArray(masIn));
    }

}
