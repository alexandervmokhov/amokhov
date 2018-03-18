package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 13.03.2018
 */
public class MaxTest {
	@Test
	public void whenFirstLessSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
	}
	
	@Test
	public void whenSecondLessFirst() {
    Max maxim = new Max();
    int result = maxim.max(2, 1);
    assertThat(result, is(2));
	}
	
	@Test
	public void whenFirstEqualSecond() {
    Max maxim = new Max();
    int result = maxim.max(2, 2);
    assertThat(result, is(2));
	}

	// Тесты для задания "Максимум из трех чисел".
	@Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result;
        result = maxim.max(1, 2);
        result = maxim.max(1, 3);
        result = maxim.max(2, 3);
        assertThat(result, is(3));
    }
}
