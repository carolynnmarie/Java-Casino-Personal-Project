package io.carolynn.casino;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void defaultConstructorTest(){
        Person person = new Person("Carolynn");
        String expected = "Carolynn";
        person.setName("Carolynn");
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructor2Test(){
        Person person = new Person("Carolynn");
        String expected = "Carolynn";
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getChipsTest(){
        Person person = new Person("Carolynn");
        Integer expected = 50;
        person.setChips(50);
        Integer actual = person.getChips();
        Assert.assertEquals(expected, actual);
    }
}
