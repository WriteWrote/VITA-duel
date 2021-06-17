package ru.obukhova.vita;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HumanPlayerBean human = context.getBean("humanPlayerBean", HumanPlayerBean.class);
        BotPlayerBean bot = context.getBean("botPlayerBean", BotPlayerBean.class);

        System.out.print("Выбираем очередность ходов... Первый ход: ");
        boolean queue = human.getCards().get(0) > bot.getCards().get(0);
        if (queue) System.out.println("человек");
        else System.out.println("бот");

        while (human.getCards().size() > 0 || bot.getCards().size() > 0) {
            if (queue) {
                System.out.println("Человек атакует.");
                round(human, bot);
                queue = false;
            } else {
                System.out.println("Бот атакует.");
                round(bot, human);
                queue = true;
            }
        }
        context.close();
    }

    private static void round(PlayerBean Pl1, PlayerBean Pl2) {
        int card1 = Pl1.getCard();
        int card2 = Pl2.getCard();
        if (card1 - card2 > 0) {
            Pl2.addPoints(card1 - card2);
            System.out.println("Штрафных очков присуждено: " + (card1 - card2));
        } else System.out.println("Штрафных очков нет");

    }
}
