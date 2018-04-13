package ru.job4j.array;

/**
 * Class Matrix для выполнения задания
 * "5.4. Двухмерный массив. Таблица умножения. [#33491]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 27.03.2018
 */
public class Matrix {

    /**
     * В методе создается двумерный массив - матрица. Внешний цикл
     * по первой размерности, внутренний цикл по второй.
     * @param size индекс массива.
     * @return возвращает массив с элементами таблицы умножения.
     */
    int[][] multiple(int size) {
        int[][] multipleTab = new int[size][size];
        for (int i = 0; i < multipleTab.length; i++) {
            for (int j = 0; j < multipleTab.length; j++) {
                multipleTab[i][j] = (i + 1) * (j + 1);
            }
        }
        return multipleTab;
    }
}
