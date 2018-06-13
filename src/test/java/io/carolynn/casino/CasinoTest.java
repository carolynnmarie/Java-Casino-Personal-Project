package io.carolynn.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CasinoTest {
    @Test
    public void testingTest(){
        Casino testing = new Casino();
        Integer[] arrayX = {2,4,7,9,10};
        Integer[] arrayY = {4,5,9,10,14};
        Integer[] arrayZ = {4,7,9,10,11};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4,9,10));
        ArrayList<Integer> actual = testing.testing(arrayX,arrayY,arrayZ);
        Assert.assertEquals(expected,actual);
    }

}
