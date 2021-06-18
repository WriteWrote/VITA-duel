package ru.obukhova.vita;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PlayerBean human = context.getBean("humanPlayerBean", PlayerBean.class);
        PlayerBean bot = context.getBean("botPlayerBean", PlayerBean.class);

        System.out.print("Выбираем очередность ходов... Первый ход: ");
        boolean queue = Math.random() <= 0.5;
        if (queue) System.out.println(human.getName());
        else System.out.println(bot.getName());

        while (human.getCards().size() > 0 || bot.getCards().size() > 0) {
            if (queue) {
                round(human, bot);
                queue = false;
            } else {
                round(bot, human);
                queue = true;
            }
        }
        System.out.println("Определяем победителя... Подсчитываем штрафные очки...");
        Thread.sleep(800);
        System.out.println(human.getName() + " - " + human.getScore() + "   vs   " + bot.getScore() + " - " + bot.getName());
        Thread.sleep(500);
        if (human.getScore() == bot.getScore()) System.out.println("Победителя нет!");
        else
            System.out.println("Победитель - " + (human.getScore() < bot.getScore() ? human.getName() : bot.getName()));
        context.close();
    }

    private static void round(PlayerBean Pl1, PlayerBean Pl2) throws InterruptedException {
        System.out.println(Pl1.getName() + " атакует.");
        Thread.sleep(1000);

        int card1 = Pl1.getCard();
        int card2 = Pl2.getCard();

        System.out.println("Открываем карты:");
        Thread.sleep(800);
        System.out.println(Pl1.getName() + " - " + card1 + "   vs   " + card2 + " - " + Pl2.getName());
        Thread.sleep(500);

        if (card1 - card2 > 0) {
            Pl2.addPoints(card1 - card2);
            System.out.println(Pl2.getName() + " присуждено " + (card1 - card2) + " штрафных очков.");
        } else System.out.println("Штрафных очков нет");
        System.out.println();
        Thread.sleep(1000);
    }
}
