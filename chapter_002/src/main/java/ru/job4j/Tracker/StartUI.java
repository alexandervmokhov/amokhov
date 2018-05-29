package ru.job4j.tracker;

import java.util.Arrays;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class StartUI {
    /**
     * Массив для выбора диапазона ключей.
     */
    private int[] ranges;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициилизирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * основной цикл программы.
     *
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ranges = new int[6];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        menu.fillActions();
        do {
            System.out.println("Menu:");
            menu.show();
            menu.select(input.ask("Select menu number:", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}