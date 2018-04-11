package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayChar2Test {
    @Test
    public void whenOriginContainsSubThenTrue() {
        ArrayChar2 word = new ArrayChar2("Hello");
        boolean result = word.contains("Hello", "ell");
        assertThat(result, is(true));
    }

    @Test
    public void whenOriginNotContainsSubThenFalse() {
        ArrayChar2 word = new ArrayChar2("Hello");
        boolean result = word.contains("Hello", "ill");
        assertThat(result, is(false));
    }
}