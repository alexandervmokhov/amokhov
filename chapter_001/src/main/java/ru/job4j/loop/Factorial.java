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
    public int calc(int n) {
        int result = 1;
        // Защита от ввода отрицательного числа.
        if (n < 0) {
            return -1;
        } else {
            //Факториал это произведение всех чисел до заданного числа.
            for (int i = 2; i <= n; i++) {
                result *= i;
                // Факториал для числа 0 равен 1
                if (n == 0 || n == 1) {
                    return result;
                }
            }
        }
        return result;
    }
}