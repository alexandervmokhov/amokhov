package ru.job4j.Tracker;

import java.util.*;

/**
 * Class Tracker для выполнения задания
 * "2. Реализовать класс Tracker [#396]".
 * Данный класс используется, как хранилище для заявок.
 *
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 16.04.2018
 */
public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Задаем идентификатор заявки.
     */
    private static final Random RN = new Random();

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Т.к. у заявки нет уникальности полей, имени и описания,
     * то для идентификации нам нужен уникальный ключ.
     * @return уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Указатель ячейки для новой заявки
     */
    private int position = 0;

    /**
     * Метод, реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализущий редактирование (замену) заявок в хранилище.
     * @param id
     */
    public void replace(String id, Item item) {
        item.getId();
        this.items[this.position-1] = item;
    }

    /**
     * Метод реализует получение заявки по Id.
     * @param id
     * @return
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализущий удаление заявки из хранилища
     * @param id
     */
    public void delete(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                System.arraycopy(this.items, items.length - 99, this.items, items.length - 100, items.length - 1);
                break;
            }
        }
    }

    /**
     * Метод, реализующий получение списка всех заявок.
     * @return
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод реализует получение списка по имени. ДОДЕЛАТЬ!
     * @param key
     * @return
     */

    public Item[] findByName(String key) {
        Item[] result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = items;
                break;
            }
        }
        return result;
    }
}
