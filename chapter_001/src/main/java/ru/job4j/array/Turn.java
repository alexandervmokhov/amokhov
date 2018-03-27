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
        int l = array.length;
        for (int i = 0; i < (l / 2); i++) {
            //например a = 3; b = 4
            array[i] = array[i] + array[(l - 1) - i]; //a = 7
            array[(l - 1) - i] = array[i] - array[(l - 1) - i]; // b = a - b = 3
            array[i] = array[i] - array[(l - 1) - i]; // a = a - b = 4
        }
        return array;
    }
}

/*
// Вариант решения задачи с двумя массивами.
int[]b = new int[array.length];
        for (int j = 0; j < array.length; j++) {
            b[j] = array[(array.length-j-1)];
        }
        return b;


 Другой способ решения задачи с одним массивом - не рабочий.
 for (int j = 0; j < array.length; j++) {
            array[j] = array[array.length-j-1];
        }
        return array;
 */