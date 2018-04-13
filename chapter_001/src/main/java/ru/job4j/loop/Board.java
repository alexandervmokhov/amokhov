package ru.job4j.loop;

/**
 * Class Board для выполнения задания
 * "Построить шахматную доску в псевдографике [#13559]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 17.03.2018
 */
public class Board {

    /**
     * Метод создает условие проверки, что писать - пробел или X
     * и закономерность, когда нужно проставлять X.
     *
     * screen.append(ln) - перевод на новую строку.
     *
     * @param width ширина.
     * @param height высота.
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((i + j) % 2 != 1) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
