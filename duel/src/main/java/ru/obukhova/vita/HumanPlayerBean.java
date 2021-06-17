package ru.obukhova.vita;

import java.util.Iterator;
import java.util.Scanner;

class HumanPlayerBean extends PlayerBean {
    @Override
    public int getCard() {
        System.out.println("Ваш ход. Выберите карту из оставшихся:");

        for (Integer c :
                super.getCards()) {
            System.out.print(c + " ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int card = scanner.nextInt();
        System.out.println("Ваш выбор: " + card);

        Iterator<Integer> iterator = super.getCards().iterator();
        while (iterator.hasNext()){
            if (iterator.next()==card){
                iterator.remove();
                break;
            }
        }

        return card;
    }
}
