package io.carolynn.casino;

import io.carolynn.casino.games.Game;
import org.junit.Assert;
import org.junit.Test;

import static io.carolynn.casino.GameFactory.goToGame;

public class GameFactoryTest {

    @Test
    public void factoryTest(){
        GameFactory factory = new GameFactory();
        Person person = new Person("Carolynn");
        Game actual = factory.goToGame("blackjack", person);
        Game expected = factory.goToGame("Craps", person);
        Assert.assertNotEquals(expected, actual);

    }
}
