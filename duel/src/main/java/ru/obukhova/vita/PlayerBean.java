package ru.obukhova.vita;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

abstract class PlayerBean {
    private int score;
    private List<Integer> cards;
    private String name;

    PlayerBean(String name) {
        this.score = 0;
        this.cards = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            this.cards.add((int) (Math.random() * (11)));
        }
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getCard() throws InterruptedException {
        return -1;
    }

    List<Integer> getCards() {
        return cards;
    }

    public void addPoints(int newPoints) {
        this.score = this.score + newPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
