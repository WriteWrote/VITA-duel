package ru.obukhova.vita;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class PlayerBean {
    private int score;
    private List<Integer> cards;

    PlayerBean() {
        this.score = 0;
        this.cards = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            this.cards.add(i);
        }
    }

    public int getScore() {
        return score;
    }

    public int getCard() {
        return cards.get(0);
    }

    List<Integer> getCards() {
        return cards;
    }

    public void addPoints(int newPoints) {
        this.score = this.score + newPoints;
    }
}
