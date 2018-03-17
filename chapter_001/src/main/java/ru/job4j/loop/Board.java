package ru.job4j.loop;

/**
 * Class Board для выполнения задания
 * "Построить шахматную доску в
 * псевдографике [#13559]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 17.03.2018
 */
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder(); //создали новый объект.
        String ln = System.lineSeparator();
        for (int i=0; i<width; i++) {
            for ( int j=0; j<height; j++) {
                // условие проверки, что писать пробел или X
                // закономерность, когда нужно проставлять X
                if ((i+j)%2 != 1) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
