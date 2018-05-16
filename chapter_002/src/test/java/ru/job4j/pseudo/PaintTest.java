package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 16.05.18
 */
public class PaintTest {

    /**
     * Алгоритм работы теста:
     *
     * Получаем ссылку на стандартный вывод в консоль.
     * Создаем буфер для хранения вывода.
     * Заменяем стандартный вывод на вывод в пямять для тестирования.
     * Выполняем действия пишущие в консоль.
     * Проверяем результат вычисления
     * Возвращаем обратно стандартный вывод в консоль.
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+ + + +")
                                .append("+     +")
                                .append("+     +")
                                .append("+ + + +")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}