package ru.job4j.loop;

/**
 * Class Counter для выполнения задания
 * "4.1. Подсчет суммы чётных чисел в диапазоне [#192]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 17.03.2018
 */
public class Counter {
	public int add(int start, int finish) {
		int result = 0;
		for (int tmp = start; tmp <= finish; tmp++) {
			if (tmp % 2 == 1) {
				continue;
			}
			result += tmp;
		}
		return result;
	}
}