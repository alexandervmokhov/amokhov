package ru.job4j.tracker;

/**
 * Данный класс принимает сообщение об ошибке в конструктор
 * и передает его в конструктор родителя.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
