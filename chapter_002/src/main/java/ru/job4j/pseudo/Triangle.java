package ru.job4j.pseudo;

import java.util.StringJoiner;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 15.05.18
 */
public class Triangle implements Shape {

    @Override
    public String draw() {
        StringJoiner pic = new StringJoiner(
                System.lineSeparator(), "",
                System.lineSeparator());
                pic.add("  ^  ");
                pic.add(" ^ ^ ");
                pic.add("^^^^^");
                return pic.toString();
    }
}