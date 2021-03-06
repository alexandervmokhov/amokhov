package ru.job4j.tracker;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public interface Input {
    String ask(String question);

    /**
     * Перегрузка метода ask.
     */
    int ask(String question, int[] range);
}