package ru.job4j.tracker;

import java.util.Arrays;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 0.1
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
     * Константа для поиска заявок по id.
     */
    private static final String FINDID = "4";

    /**
     * Константа для поиска заявок по имени.
     */
    private static final String FINDNAME = "5";

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
                this.createItem();
                } else if (SHOW.equals(answer)) {
                this.showItem();
                } else if (EDIT.equals(answer)) {
                this.editItem();
                } else if (DEL.equals(answer)) {
                this.deleteItem();
                } else if (FINDID.equals(answer)) {
                this.findItem();
                } else if (FINDNAME.equals(answer)) {
                this.findNameItem();
                } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует вывод на экран пункты основного меню.
     */
    private void showMenu() {
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        boolean exit = false;
        System.out.println("----------- New query adding -----------");
        String name = this.input.ask("Enter query name: ");
        String desc = this.input.ask("Enter description of query: ");
        long create = this.input.askL("Enter new long number: ");
        Item item = new Item(name, desc, create);
        this.tracker.add(item);
        System.out.println("------------ New query with getId: " + item.getId() + " added. --------");
    }

    /**
     * Метод реализует вывод на экран всех заявок.
     */
    private void showItem() {
        for (int i = 0; i < tracker.getAll().length; i++) {
            if (tracker.getAll()[i] != null) {
                System.out.print("ID: " + tracker.getAll()[i].getId() + ", ");
                System.out.print(tracker.getAll()[i].getName() + ", ");
                System.out.print(tracker.getAll()[i].getDescription() + ", ");
                System.out.println(tracker.getAll()[i].getCreate());
            }
        }
    }

     /**
     * Метод реализует замену заявки в хранилище.
     */
    private void editItem() {
        System.out.println("----------- New query replacing menu -----------");
        String id = this.input.ask("Enter query ID: ");
        Item previous = this.tracker.findById(id);
        System.out.println("Current query name is: " + tracker.findById(id).getName());
        String name = this.input.ask("Enter new query name: ");
        String desc = this.input.ask("Enter new query description: ");
        long create = Long.parseLong(this.input.ask("Enter new long number: "));
        Item next = new Item(name, desc, create);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        System.out.println("------------ This query: " + tracker.findById(id).getName() + " was changed. --------");
        System.out.println("------------ It has ID: " + next.getId() + "  --------");
    }

    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItem() {
        System.out.println("----------- Query deleting -----------");
        String id = this.input.ask("Enter query ID: ");
        System.out.println("Deletind query name is: " + tracker.findById(id).getName());
        tracker.delete(id);
        System.out.println("------------ This query was deleted: --------");
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void findItem() {
        System.out.println("----------- Query finding -----------");
        String id = this.input.ask("Enter query ID: ");
        System.out.print("Founded query is: " + id + ", ");
        System.out.print(tracker.findById(id).getName() + ", ");
        System.out.println(tracker.findById(id).getDescription());
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findNameItem() {
        System.out.println("----------- Query finding -----------");
        String name = this.input.ask("Enter query name: ");
        for (int i = 0; i < tracker.getAll().length; i++) {
            if (tracker.getAll() != null && name != null && tracker.findByName(name)[i].getName().equals(name)) {
                System.out.print("ID: " + tracker.getAll()[i].getId() + ", ");
                System.out.print(tracker.getAll()[i].getName() + ", ");
                System.out.print(tracker.getAll()[i].getDescription() + ", ");
                System.out.println(tracker.getAll()[i].getCreate());
            }
        }
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

