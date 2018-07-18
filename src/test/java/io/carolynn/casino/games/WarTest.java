package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.games.cardGames.War;
import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    Person player = new Person("James");
    War war = new War(player);
    @Test
    public void constructorTest(){
        int expected = 26;
        int actual = war.getDealerHand().size();
        Assert.assertEquals(expected, actual);
    }
}
