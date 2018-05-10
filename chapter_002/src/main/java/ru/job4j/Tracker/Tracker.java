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
     *
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
     * Метод должен заменить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if(items[index].getId().equals(id)) {
                item.setId(items[index].getId());
                items[index] = item;
                break;
            }
        }
    }

    /**
     * Метод реализует получение заявки по Id.
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
     * Метод реализует удаление заявки из хранилища.
     *
     * Метод удаляет ячейку в массиве this.items. Для этого
     * необходимо найти ячейку в массиве по id.  Далее сместить
     * все значения справа от удаляемого элемента - на одну
     * ячейку влево с помощью System.arraycopy();
     */
    public void delete(String id) {
        for (int index = 0; index < items.length; index++) {
            if(items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
                break;
            }
        }
    }

    /**
     * Метод, реализующий получение списка всех заявок.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод реализует получение списка по имени.
     *
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с
     * аргументом метода String key. Элементы, у которых совпадает
     * name, копирует в результирующий массив и возвращает его;
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result = items;
                break;
            }
        }
        return result;
    }
}
