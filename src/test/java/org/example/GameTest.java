package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    Game game = new Game();

    Player player1 = new Player(1, "Андрей", 100);
    Player player2 = new Player(7, "Иван111", 98);
    Player player3 = new Player(23, "Ололо*#", 1000);
    Player player4 = new Player(89, "Маруся", 100);
    Player player5 = new Player(100, "Анка", 500);

    @Test

    public void roundNotPossibleIfPlayer1NotRegistered() {

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test

    public void roundNotPossibleIfPlayer2NotRegistered() {

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player3.getName());
        });
    }

    @Test
    public void roundNotPossibleIfBothPlayersNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Анечка", "Алёша");
        });
    }

    @Test
    public void compareStrengthIfBothPlayersEqual() {

        game.register(player1);
        game.register(player4);

        Assertions.assertEquals(0, game.round(player1.getName(), player4.getName()));
    }


    @Test
    public void compareStrengthIfPlayer1IsStronger() {

        game.register(player5);
        game.register(player4);

        Assertions.assertEquals(1, game.round(player5.getName(), player4.getName()));
    }

    @Test
    public void compareStrengthIfPlayer2IsStronger() {

        game.register(player2);
        game.register(player4);

        Assertions.assertEquals(2, game.round(player2.getName(), player4.getName()));
    }

}

