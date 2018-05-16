package ru.job4j.pseudo;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 15.05.18
 */
public class Paint {

    /**
     * Метод draw выводит печать псевдокартинки на консоль
     * через метод System.out.println(shape.draw())
     * @param shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
