package ru.job4j.tracker;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public interface Input {
    String ask(String question);
    long askL(String question);
}

