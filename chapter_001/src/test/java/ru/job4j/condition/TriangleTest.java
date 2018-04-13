package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 13.03.2018
 */
public class TriangleTest {

    /**
     * Создаем три объекта класса Point.
     * Создаем объект треугольник и передаем в него объекты точек.
     * Вычисляем площадь.
     * Задаем ожидаемый результат.
     * Проверяем результат и ожидаемое значение.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}