package ru.job4j.Tracker;

public class Item {
    /**
     * Модификатор поля ID. Определяет уникальный номер для каждого Item.
     */
    private String id;

    public String name;

    public String description;

    public long create;

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
        return description;
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
