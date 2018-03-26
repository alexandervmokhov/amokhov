package ru.job4j.array;

/**
 * Class Turn для выполнения задания
 * "5.2. Перевернуть массив. [#4441]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */
public class Turn {
    public int[] turn(int[] array) {
        for (int j = 0; j < array.length; j++) {
            array[j] = array[array.length-j-1];
        }
        return array;
    }
}

/*
int[]b = new int[array.length];
        for (int j = 0; j < array.length; j++) {
            b[j] = array[(array.length-j-1)];
        }
        return b;
 */