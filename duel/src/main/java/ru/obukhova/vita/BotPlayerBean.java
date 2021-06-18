package ru.obukhova.vita;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class BotPlayerBean extends PlayerBean {
    BotPlayerBean(String name) {
        super(name);
    }

    @Override
    public int getCard() throws InterruptedException {
        System.out.println("Ход бота. Выбирает карту...");
        Thread.sleep(700);

        int card = chooseMedian();

        System.out.println("Бот выбрал карту.");
        Thread.sleep(1000);
        return card;
    }

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

    private int chooseMin() {
        int minIndex = -1;
        int minEl = super.getCards().get(0);
        for (int i = 1; i < super.getCards().size(); i++) {
            if (super.getCards().get(i) > minEl) {
                minEl = super.getCards().get(i);
                minIndex = i;
            }
        }
        super.getCards().remove(minIndex);
        return minEl;
    }

    private int chooseRandom() {
        int index = (int) (Math.random() * super.getCards().size());
        return super.getCards().get(index);
    }

    private int chooseMedian() {
        // выбираем 7, 8, 9, затем 5, 6, 4, затем 0-3, затем 10, 11
        // смотрим сквозь массив и разбираем его на четыре массива
        List<List<Integer>> list = new ArrayList<>();
        int card = -1;
        for (int i = 0; i < 4; i++)
            list.add(new ArrayList<Integer>());
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

    private int browseCard(List<Integer> list) {
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
