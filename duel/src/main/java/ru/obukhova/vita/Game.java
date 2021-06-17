package ru.obukhova.vita;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playerList;
    boolean queue = false;

    public Game(List<Player> playerList) {
        this.playerList = new ArrayList<>();
        this.playerList.add(new HumanPlayer());
        this.playerList.add(new BotPlayer());
    }

    public void playGame() {
        System.out.println(
                "Game is playing with itself"
        );
        System.out.print("Выбираем очередность ходов... Первый ход: ");
        if (queue) System.out.println("человек");
        else System.out.println("бот");

        while (playerList.get(0).getCards().size() > 0 || playerList.get(0).getCards().size() > 0) {
            if (queue) {
                System.out.println("Человек атакует.");
                round(playerList.get(0), playerList.get(1));
            } else {
                System.out.println("Бот атакует.");
                round(playerList.get(1), playerList.get(0));
            }
        }
    }

    private void round(Player Pl1, Player Pl2) {
        int card1 = Pl1.getCard();
        int card2 = Pl2.getCard();
        if (card1 - card2 > 0) {
            Pl2.addPoints(card1 - card2);
            System.out.println("Штрафных очков присуждено: " + (card1 - card2));
        } else System.out.println("Штрафных очков нет");

    }
}
