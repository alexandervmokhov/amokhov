package ru.job4j.array;

/**
 * Class FindLoop для выполнения задания
 * "5.1. Классический поиск перебором. [#33489]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */
public class FindLoop {

    /**
     * Метод возвращает индекс первого вхождения указанного символа, начиная
     * поиск по указанному индексу, или значение -1, если символ не встречается.
     * @param data массив целочисленных значений.
     * @param el элемент, который нужно найти в массиве.
     * @return возвращает найденный индекс.
     */
    public int indexOf(int[] data, int el) {
        int rsl = -1;
        for (int index : data) {
            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}