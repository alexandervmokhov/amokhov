package ru.job4j.array;

/**
 * Class BubbleSort для выполнения задания
 * "5.3. Создать программу для сортировки массива
 * методом перестановки. [#195]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */
public class BubbleSort {

    /**
     * В данном методе используется сортировка пузырьком. Внешний
     * цикл каждый раз сокращает фрагмент массива, т.к. внутренний
     * цикл каждый раз ставит в конец фрагмента максимальный элемент.
     * @param array сортируемый массив.
     * @return возвращает отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
