package ru.job4j.Tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    public long askL(String question) {
        System.out.print(question);
        return scanner.nextLong();
    }
}
