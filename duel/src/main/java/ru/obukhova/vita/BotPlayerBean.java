package ru.obukhova.vita;

class BotPlayerBean extends PlayerBean {
    BotPlayerBean(String name) {
        super(name);
    }

    @Override
    public int getCard() throws InterruptedException {
        System.out.println("Ход бота. Выбирает карту...");
        Thread.sleep(700);

        int card = chooseMax();

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
}
