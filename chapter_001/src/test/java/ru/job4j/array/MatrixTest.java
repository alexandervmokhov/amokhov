package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 27.03.2018
 */
public class MatrixTest {
    @Test
    public void whenSize3ThenMultipleTableArray3x3() {
        int size = 3;
        Matrix matrix = new Matrix();
        int[][] multiple = matrix.multiple(size);
        int[][] expect = new int[][] {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(multiple, is(expect));
    }

    @Test
    public void whenSize6ThenMultipleTableArray6x6() {
        int size = 6;
        Matrix matrix = new Matrix();
        int[][] multiple = matrix.multiple(size);
        int[][] expect = new int[][] {
                {1, 2, 3, 4, 5, 6},
                {2, 4, 6, 8, 10, 12},
                {3, 6, 9, 12, 15, 18},
                {4, 8, 12, 16, 20, 24},
                {5, 10, 15, 20, 25, 30},
                {6, 12, 18, 24, 30, 36}
        };
        assertThat(multiple, is(expect));
    }
}