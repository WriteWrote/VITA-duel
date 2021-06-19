package ru.obukhova.vita;

import java.util.LinkedList;
import java.util.List;

/**
 * An abstract class that represents basic behaviour of Player.
 * Contains personal name and score of Player and his set of cards.
 */
abstract class PlayerBean {
    private int score;
    private List<Integer> cards;
    private String name;

    /**
     * Creates an object of class, sets score = 0 and
     * fills LinkedList of cards with numbers from 0 to 11
     *
     * @param name name of player, injected by Spring Bean
     */
    PlayerBean(String name) {
        this.score = 0;
        this.name = name;
        this.cards = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            this.cards.add(i);
        }
    }

    /**
     * Abstract method which returns a number, representing the card.
     *
     * @return number of card
     * @throws InterruptedException because extensions of this method use
     *                              {@code Thread.sleep()}
     */
    public abstract int getCard() throws InterruptedException;

    public int getScore() {
        return score;
    }

    List<Integer> getCards() {
        return cards;
    }

    /**
     * This void do not exactly set new number of Points, although it comes from the setter.
     * It takes as a parameter some number which represents additional
     * points and adds them to personal and already existing score of Player.
     *
     * @param newPoints number of additional points
     */
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
