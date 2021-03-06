package ru.job4j.condition;

/**
 * Class Triangle для выполнения задания
 * "3.3. Вычисление площади треугольника [#9461]".
 *
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 13.03.2018
 */
public class Triangle {
	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Метод вычисления полупериметра по длинам сторон.
	 * Формула вычисления периметра: (ab + ac +bc)/2
	 * @param ab расстояние между точками a b
	 * @param ac расстояние между точками a c
	 * @param bc расстояние между точками b c
	 * @return Периметр.
	 */
	public double period(double ab, double ac, double bc) {
		return (ab + ac + bc) / 2;
	}

	/**
	 * Метод вычисляет площадь треугольника по формуле Герона.
	 * @return Вернуть площадь, если треугольник существует или -1, если треугольника нет.
	 */
	public double area() {
		double rsl = -1;
		double ab = this.a.distanceTo(this.b);
		double ac = this.a.distanceTo(this.c);
		double bc = this.b.distanceTo(this.c);
		double p = this.period(ab, ac, bc);
		if (this.exist(ab, ac, bc)) {
			rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
		}
		return rsl;
	}

	/**
	 * Метод проверяет можно ли построить треугольник с такими длинами сторон.
	 * @param ab Длина от точки a b.
	 * @param ac Длина от точки a c.
	 * @param bc Длина от точки b c.
	 * @return Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
	 */
	public boolean exist(double ab, double ac, double bc) {
		boolean exist = false;
		if (ab + bc > ac && ab + ac > ab && ac + bc > ab) {
			exist = true;
		}
		return exist;
	}
}
  
  