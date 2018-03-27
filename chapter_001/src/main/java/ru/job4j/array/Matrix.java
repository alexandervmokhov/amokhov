package ru.job4j.array;

/**
 * Class Square для выполнения задания
 * "5.4. Двухмерный массив. Таблица умножения. [#33491]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 27.03.2018
 */
public class Matrix {
    int[][] multiple(int size) {
        // создаем двумерный массив
        int[][] multipleTab = new int[size][size];

        // цикл по первой размерности
        for (int i = 0; i < multipleTab.length; i++) {
            // цикл по второй размерности
            for (int j = 0; j < multipleTab.length; j++) {
                // инициализация элементов массива
                multipleTab[i][j] = (i + 1) * (j + 1);
            }
        }
        return multipleTab;
    }
}
