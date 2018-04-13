package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 17.03.2018
 */
public class CounterTest {

    /**
     * тест, проверяющий, что сумма чётных чисел от 1 до 10
     * при вызове метода counter.add будет равна 30.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }
}