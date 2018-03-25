package ru.job4j.array;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 17.03.2018
 */

public class FindLoopTest {
    @Test
    public void findIndexOfData() {
        int[] data = new int[] {0, 1, 2, 3, 4, 5, 6};
        FindLoop findLoop = new FindLoop();
        int rsl = findLoop.indexOf(data, 3);
        int expect = 3;
        assertThat(rsl, is(expect));
    }
}
