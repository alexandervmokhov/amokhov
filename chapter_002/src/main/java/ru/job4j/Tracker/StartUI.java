package ru.job4j.Tracker;

import java.util.Arrays;

//import jdk.internal.util.xml.impl.Input;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для замены заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для замены заявки.
     */
    private static final String DEL = "3";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter menu item: ");
            if (ADD.equals(answer)) {
                // добавление заявки вынесено в отдельный метод.
                this.createItem();
                } else if (SHOW.equals(answer)) {
                this.showItem();
                } else if (EDIT.equals(answer)) {
                this.editItem();
                } else if (DEL.equals(answer)) {
                this.deleteItem();
                // Добавить остальные действия системы по меню
                } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("----------- New query adding -----------");
        String name = this.input.ask("Enter query name: ");
        String desc = this.input.ask("Enter description of query: ");
        //long create = this.input.ask("Введите число типа Long: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New query with getId: " + item.getId() + " added. --------" );
    }

    /**
     * Метод реализует вывод на экран всех заявок.
     */
    private void showItem() {
        for (int i = 0; i < tracker.getAll().length; i++) {
            //if (tracker.getAll() != null) {
                System.out.print("ID: " + tracker.getAll()[i].getId() + ", ");
                System.out.print(tracker.getAll()[i].getName() + ", ");
                System.out.println(tracker.getAll()[i].getDescription() + ", ");
            //}

        }

    }

    private void showMenu() {
        //System.out.println("Welcome to query processor program.");
        //System.out.println("Use 0 - 6 characters for menu operation.");
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("6. Exit Program");
        //добавить остальные пункты меню.
    }

     /**
     * Метод реализует замену заявки в хранилище. ДОДЕЛАТЬ!
     */
    private void editItem() {
        System.out.println("----------- New query replacing -----------");
        String id = this.input.ask("Enter query ID: ");
        //Item previous = this.tracker.findById(id);
        System.out.println("Current query name is: " + tracker.findById(id).getName());
        String name = this.input.ask("Enter new query name: ");
        String desc = this.input.ask("Enter new query description: ");
        Item item = new Item(name, desc);
        item.setId(id);
        //next.setId(id);
        //this.tracker.replace(id, next);
        tracker.replace(id, item);
        System.out.println("------------ New query: " + tracker.findById(id).getName() + " replaced. --------" );
        System.out.println("------------ It has ID: " + item.getId() + "  --------" );
    }

    /**
     * Метод реализует удаление заявки из хранилища. ДОДЕЛАТЬ!
     */
    private void deleteItem() {
        System.out.println("----------- Query deleting -----------");
        String id = this.input.ask("Enter query ID: ");
        System.out.println("Deletind query name is: " + tracker.findById(id).getName());
        tracker.delete(id);
        System.out.println("------------ This query was deleted: --------" );
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

