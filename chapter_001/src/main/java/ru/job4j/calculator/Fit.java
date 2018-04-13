package ru.job4j.calculator;

/**
 * Class Fit для выполнения задания "3.3. Идеальный вес. [#41584]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 13.03.2018
 */
public class Fit {

    /**
     * Идеальный вес для мужчин = (рост в сантиметрах – 100) * 1,15.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100.0) * 1.15;
    }

    /**
     * Идеальный вес для женщин = (рост в сантиметрах – 110) * 1,15.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110.0) * 1.15;
    }
}
