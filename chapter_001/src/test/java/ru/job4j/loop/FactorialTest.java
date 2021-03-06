package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 16.03.2018
 */
public class FactorialTest {

    /**
     * Тест, проверяющий, что факториал числа 5 равен 120.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial factor = new Factorial();
        factor.calc(5);
        int result = factor.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Тест, проверяющий, что факториал для числа 0 равен 1.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factor = new Factorial();
        factor.calc(0);
        int result = factor.calc(0);
        assertThat(result, is(1));
    }
}