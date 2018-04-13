package ru.job4j.loop;

/**
 * Class Factorial для выполнения задания:
 * "4.2. Создать программу вычисляющую факториал. [#193]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 16.03.2018
 */
public class Factorial {

    /**
     * В методе есть защита от ввода отрицательного числа.
     * Факториал - это произведение всех чисел до заданного числа.
     * Факториал для числа 0 равен 1.
     * @param n целое число.
     * @return возвращает факториал положительных чисел.
     */
    public int calc(int n) {
        int result = 1;
        if (n < 0) {
            return -1;
        } else {
            for (int i = 2; i <= n; i++) {
                result *= i;
                if (n == 0 || n == 1) {
                    return result;
                }
            }
        }
        return result;
    }
}