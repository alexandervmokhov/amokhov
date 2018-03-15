package ru.job4j.max;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 15.03.2018
  */

// Метод для вычисления максимума из двух чисел
public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    // Метод для вычисления максимума из трех чисел
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        temp = this.max(first, third);
        temp = this.max(second, third);
        return temp;
    }
}