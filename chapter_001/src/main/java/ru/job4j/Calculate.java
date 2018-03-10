package ru.job4j;

/**
* Class Calculate для выполнения задания 1.1. Создание Hello World [#141]. 
*
* @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
* @version 1
* @since 10.03.2018
*/
public class Calculate {
	/**
	* Main.
	* @param args - args.
	*/	
	public static void main(String[] args) {
		System.out.println("Hello world.");
	}
	
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}