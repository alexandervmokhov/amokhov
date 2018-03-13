package ru.job4j.condition;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 13.03.2018
 */
public class DummuBot {
	/**
	 * Отвечает на вопросы.
	 *@param question Вопрос от клиента.
	 */
	public String answer(String question) {
		String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
		if ("Привет, Бот".equals(question)) {
			rsl = "Привет, умник.";
		} else if ("Пока.".equals(question)) {
			rsl = "До скорой встречи.";
		}
		return rsl;
	}
}