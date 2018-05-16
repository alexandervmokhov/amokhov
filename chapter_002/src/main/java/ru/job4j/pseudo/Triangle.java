package ru.job4j.pseudo;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 15.05.18
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  + +  ");
        pic.append(" + + + ");
        pic.append("+ + + +");
        return pic.toString();
    }
}