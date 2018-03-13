package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public int RubleToEuro(int value) {
        return value * 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары
     */
    public int RubleToDollar(int value) {
        return value * 60;
    }
	
	/**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int EuroToRuble(int value) {
        return value / 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public int DollarToRuble(int value) {
        return value / 60;
    }
}