package ru.job4j.pseudo;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 15.05.2018
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+ + + +");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("+ + + +");
        return pic.toString();
    }
}