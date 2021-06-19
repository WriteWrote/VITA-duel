package ru.obukhova.vita;

import java.util.Iterator;
import java.util.Scanner;

class HumanPlayerBean extends PlayerBean {

    HumanPlayerBean(final String name) {
        super(name);
    }

    /**
     * Overridden method which communicates with actual player.
     * It lets player to choose from leftover cards and deletes chosen card
     * with {@code Iterator}, because deleting goes by value, not by index.
     *
     * @return number which represents the actual card
     * @throws InterruptedException because uses {@code Thread.sleep()}
     */
    @Override
    public int getCard() throws InterruptedException {
        System.out.println("Ваш ход. Выберите карту из оставшихся:");
        Thread.sleep(500);

        for (Integer c :
                super.getCards()) {
            System.out.print(c + " ");
            Thread.sleep(200);
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int card = scanner.nextInt();
        System.out.println("Ваш выбор: " + card);
        Thread.sleep(500);

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
