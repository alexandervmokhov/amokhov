package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 13.03.2018
 */
public class DummyBotTest {
	@Test
	public void whenGreetBot() {
		DummyBot bot = new DummyBot();
		assertThat(
				bot.answer("Привет, Бот."),
				is("Привет, умник.")
		);
	}
	
	@Testpublic void whenByuBot() {
		DummyBot bot = new DummyBot();
		assertThat(
				bot.answer("Пока".),
				is("До скорой встречи.")
		);
	}
	
	@Test
	public void whenUnknownBot() {
		DummyBot bot = new DummyBot();
		assert that(
				bot.answer("Сколько будет 2 + 2?"),
				is("Это ставит меня в тупик. Спросите другой вопрос.")
		);
	}
}	
	