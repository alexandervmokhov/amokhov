package ru.job4j.array;

/**
 * Class Square для выполнения задания
 * "5.0. Заполнить массив числами,
 * возведенными в квадрат. [#33488]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 19.03.2018
 */
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
            }
        return rst;
    }
}