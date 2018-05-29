package ru.job4j.tracker;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 0.1
 */
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        //return key;
        //return exist ? key : -1;
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
        //return  exist ? key : throw new MenuOutException("Out of menu range.");
    }
}