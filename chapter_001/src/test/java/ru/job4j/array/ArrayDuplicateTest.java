package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 04.04.2018
 */

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов
        // строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] resultArray = arrayDuplicate.remove(input);
        String[] expectArray = new String[] {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }
}