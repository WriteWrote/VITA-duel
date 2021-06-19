package ru.obukhova.vita;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BotPlayerBean extends PlayerBean {

    BotPlayerBean(final String name) {
        super(name);
    }

    /**
     * This overridden method covers the actual algorithm of choosing the card.
     * Different types of algorithms are hidden in private methods.
     *
     * @return number which represents a card
     * @throws InterruptedException because uses {@code Thread.sleep()}
     */
    @Override
    public int getCard() throws InterruptedException {
        System.out.println("Ход бота. Выбирает карту...");
        Thread.sleep(700);
        // type of algorithm. Still thinking how to invert
        // the choice of it, if it's even possible
        int card = chooseMedian();

        System.out.println("Бот выбрал карту.");
        Thread.sleep(1000);
        return card;
    }

    /**
     * Algorithm which firstly chooses maximum numbers.
     * Basically it goes from 11 to 0.
     *
     * @return number which represents a card
     */
    private int chooseMax() {
        int maxIndex = 0;
        int maxEl = super.getCards().get(0);
        for (int i = 0; i < super.getCards().size(); i++) {
            if (super.getCards().get(i) > maxEl) {
                maxEl = super.getCards().get(i);
                maxIndex = i;
            }
        }
        super.getCards().remove(maxIndex);
        return maxEl;
    }

    /**
     * Algorithm which firstly chooses minimum numbers.
     * Basically it goes from 0 to 11.
     *
     * @return number which represents a card
     */
    private int chooseMin() {
        int minIndex = 0;
        int minEl = super.getCards().get(0);
        for (int i = 0; i < super.getCards().size(); i++) {
            if (super.getCards().get(i) > minEl) {
                minEl = super.getCards().get(i);
                minIndex = i;
            }
        }
        super.getCards().remove(minIndex);
        return minEl;
    }

    /**
     * Algorithm that chooses random numbers from [0-11]
     *
     * @return number which represents a card
     */
    private int chooseRandom() {
        int index = (int) (Math.random() * super.getCards().size());
        int card = super.getCards().get(index);
        super.getCards().remove(index);
        return card;
    }

    /**
     * Algorithm that divides cards from superclass list into four baskets:
     * [0-3], [4-6], [7-9], [10-11]. Then it picks numbers in that order:
     * two random numbers from [4-6]
     * two random numbers from [7-9]
     * all minimum numbers from [0-3] (also randomly)
     * leftover number from [4-6]
     * leftover number from [7-9]
     * randomly picks all numbers from [10-11]
     *
     * @return number which represents a card
     */
    private int chooseMedian() {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            list.add(new ArrayList<Integer>());
        int card = -1;

        for (int c : super.getCards()) {
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                    list.get(0).add(c);
                    break;
                case 4:
                case 5:
                case 6:
                    list.get(1).add(c);
                    break;
                case 7:
                case 8:
                case 9:
                    list.get(2).add(c);
                    break;
                case 10:
                case 11:
                    list.get(3).add(c);
                    break;
            }
        }

        if (list.get(1).size() > 1) return browseCard(list.get(1));
        if (list.get(2).size() > 1) return browseCard(list.get(2));
        if (list.get(0).size() > 0) return browseCard(list.get(0));

        if (list.get(1).size() > 0) return browseCard(list.get(1));
        if (list.get(2).size() > 0) return browseCard(list.get(2));

        if (list.get(3).size() > 0) return browseCard(list.get(3));

        return card;
    }

    /**
     * Method that randomly picks a number from list of cards,
     * then deletes picked value of card from superclass' list of cards.
     *
     * @param list list of numbers in basket
     * @return number that represents a card
     */
    private int browseCard(final List<Integer> list) {
        int index = (int) (Math.random() * list.size());
        int card = list.get(index);

        Iterator<Integer> iterator = super.getCards().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == card) {
                iterator.remove();
                break;
            }
        }
        return card;
    }
}
