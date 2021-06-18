package ru.obukhova.vita;

import java.util.Iterator;
import java.util.Scanner;

class HumanPlayerBean extends PlayerBean {
    HumanPlayerBean(String name) {
        super(name);
    }

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
