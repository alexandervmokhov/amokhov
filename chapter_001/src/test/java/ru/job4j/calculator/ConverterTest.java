package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60rubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    public void when70rubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(70);
        assertThat(result, is(1));
    }
}