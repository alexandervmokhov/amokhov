package ru.job4j.pseudo;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 16.05.2018
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^ ^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }
}