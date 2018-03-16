package ru.job4j.loop;

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