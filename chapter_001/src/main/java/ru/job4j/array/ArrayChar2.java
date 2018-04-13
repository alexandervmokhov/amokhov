package ru.job4j.array;

/**
 * Class ArrayChar2 для выполнения задания
 * "Проверка, что одно слово находится в другом слове [#228]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 11.04.2018
 */
public class ArrayChar2 {

    /**
     * Проверяет, что слово содержит часть слова.
     * @param origin слово целиком.
     * @param sub часть слова.
     * @return если слово целиком содержит часть слова.
     */
    public boolean contains(String origin, String sub) {
        boolean result = true;
        char[] value = sub.toCharArray();
        char[] data = origin.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i+1] != value[i]) {
                result = false;
            }
        }
        return result;
    }
}
