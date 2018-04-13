package ru.job4j.array;

/**
 * Class Turn для выполнения задания "5.2. Перевернуть массив. [#4441]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */
public class Turn {
    public int[] turn(int[] array) {

        /**
         * Метод переворачивает элементы массива задом наперед, без использования
         * дополнительных массивов.
         * Для ясности возьмем пример, где a = 3; b = 4
         * Первое вычисление:  a = a + b (3 + 4 = 7).
         * Второе вычисление: b = a - b (7 - 4 = 3).
         * Третье вычисление: a = a - b (7 - 3 = 4).
         */
        int l = array.length;
        for (int i = 0; i < (l / 2); i++) {
            array[i] = array[i] + array[(l - 1) - i];
            array[(l - 1) - i] = array[i] - array[(l - 1) - i];
            array[i] = array[i] - array[(l - 1) - i];
        }
        return array;
    }
}