package ru.job4j.array;

/**
 * Class ArrayChar для выполнения задания
 * "5.5. Слова начинается с ... [#41585]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 30.03.2018
 */
public class ArrayChar {
    private char[] data;

    /**
     * Обертка над строкой.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса. Т.е. массив data
     * имеет первые элементы, одинаковые с value.
     * Выбираем длину value.length как наиболее короткую.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
