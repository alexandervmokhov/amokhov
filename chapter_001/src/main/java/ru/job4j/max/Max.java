package ru.job4j.max;

/**
 * Class Max для выполнения задания:
 * "3.4. Максимум из трех чисел [#190]".
 *
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 15.03.2018
  */
public class Max {

    /**
     * Метод для вычисления максимума из двух чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @return - возвращает наибольшее из двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод для вычисления максимума из трех чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - возвращает наибольшее из трех чисел.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        int result = this.max(temp, third);
        return result;
    }
}