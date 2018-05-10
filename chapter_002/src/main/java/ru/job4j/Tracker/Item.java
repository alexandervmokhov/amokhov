package ru.job4j.Tracker;

/**
 * Class Item для выполнения задания
 * "2. Реализовать класс Tracker [#396]".
 * Данный класс используется для описания заявок.
 *
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 16.04.2018
 */
public class Item {
    /**
     * Модификатор поля ID. Определяет уникальный номер для каждого Item.
     */
    private String id;

    private String name;

    private String description;

    private long create;

    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public  long getCreate() {
        return this.create;
    }

    /**
     * Метод для получения значения id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Метод для установки значения id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
