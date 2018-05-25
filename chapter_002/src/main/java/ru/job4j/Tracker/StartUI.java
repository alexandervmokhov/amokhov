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
    //private int[] ranges = new int[] {0, 1, 2, 3, 4, 5}; // доработать, чтобы это поле заполнялось из меню (метод init)
    private int[] ranges = new int[] {Integer.valueOf(input.ask("Select:"))};
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
     */
    public void init() {
        //Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            System.out.println("Menu:");
            menu.show();
            //int key = Integer.valueOf(input.ask("Select:"));
            //menu.select(key);
            menu.select(input.ask("Select menu number:", ranges)); // выбрать диапазон ключей
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

