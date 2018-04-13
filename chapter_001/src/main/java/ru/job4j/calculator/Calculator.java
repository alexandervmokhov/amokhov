package ru.job4j.calculator;

/**
 * Class Calculator для выполнения задания "3.1. Элементарный калькулятор. [#185]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 12.03.2018
 */
public class Calculator {
    private double result;
    
    public void add(double first, double second) {
        this.result = first + second;
    }
    
	public void subtract(double first, double second) {
        this.result = first - second;
    }
	
	public void div(double first, double second) {
        this.result = first / second;
    }
	
	public void multiple(double first, double second) {
        this.result = first * second;
    }
	
    public double getResult() {
        return this.result;
    }
}