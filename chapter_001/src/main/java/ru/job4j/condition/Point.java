package ru.job4j.condition;

/**
 * Class Point для выполнения задания
 * "3.4. Расстояние между точками в системе координат [#188]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 13.03.2018
 */
public class Point {
    private int x;
    private int y;

    /**
     * Инициализация точки в двумерной системе координат.
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод принимает другую точку (тип данных точка) и возвращает
     * вычисленное расстояние от текущей точки до входящей.
     * @param that другая точка.
     * @return вычисленное расстояние от текущей точки до входящей.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Cоздали два объекта типа Point и заполнили их значениями.
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}