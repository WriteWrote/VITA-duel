package ru.obukhova.vita;

import java.util.List;

public class Game {
    private List<IPlayer> playerList;

    public Game(List<IPlayer> playerList) {
        this.playerList = playerList;
    }

    public void playGame(){
        System.out.println(
                "Game is playing with itself"
        );
    }
}
