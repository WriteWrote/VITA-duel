package ru.obukhova.vita;

class BotPlayerBean extends PlayerBean {
    @Override
    public int getCard() {
        System.out.println("Ход бота. Выбирает карту...");

        int card = chooseMax();

        System.out.println("Бот выбрал карту.");
        return card;
    }

    private int chooseMax() {
        int maxIndex = -1;
        int maxEl = super.getCards().get(0);
        for (int i = 1; i < super.getCards().size(); i++) {
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
