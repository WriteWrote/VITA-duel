package ru.obukhova.vita;

import java.util.Iterator;

class BotPlayer extends Player {
    @Override
    public int getCard() {
        System.out.println("Ход бота. Выбирает карту...");

        int card = chooseMax();

        System.out.println("Бот выбрал карту.");
        return card;
    }

    private int chooseMax() {
        Iterator<Integer> iterator = super.getCards().iterator();
        int max = -1;
        // сделать удаление максимального элемента за одну проходку

        while (iterator.hasNext()){

        }

        return -1;
    }

    private int chooseMin() {
        return -1;
    }
}
