package ru.job4j.tracker;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 14.05.2018
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * @Before - выполняет метод, до запуска теста.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));

    }

    /**
     * @After - Выполняет метод, после запуска теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест проверяет правильность вывода на экран результата действий
     * пользователя при выборе меню "1" (вывод всех заявок).
     */
    @Test
    public void whenGetAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 1);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 2);
        tracker.add(second);
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit item.")
                                .append(System.lineSeparator())
                                .append("3. Delete item.")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id.")
                                .append(System.lineSeparator())
                                .append("5. Find items by name.")
                                .append(System.lineSeparator())
                                .append(first.getId() + ". ")
                                .append("test1. testDescription1. 1")
                                .append(System.lineSeparator())
                                .append(second.getId() + ". ")
                                .append("test2. testDescription2. 2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тест проверяет правильность вывода на экран результата действий
     * пользователя при выборе меню "0" (добавление заявки).
     */
    @Test
    public void whenAddNewItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator())
                                .add("Menu:")
                                .add("0. Add the new item.")
                                .add("1. Show all items.")
                                .add("2. Edit item.")
                                .add("3. Delete item.")
                                .add("4. Find item by Id.")
                                .add("5. Find items by name.")
                                .add("----------- New item adding menu -----------")
                                .add("------------ New item with Id: "
                                        + tracker.getAll()[0].getId()
                                        + " added. --------")
                                .toString()
                )
        );
    }

    /**
     * Тест для вывода всех заявок.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 1);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 2);
        tracker.add(second);
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
        assertThat(tracker.getAll()[1].getName(), is("test2"));
    }

    /**
     * Тест для добавления заявки.
     *
     * Алгоритм работы:
     * Создаём Tracker
     * Создаём StubInput с последовательностью действий
     * Создаём StartUI и вызываем метод init()
     * Проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "testName", "desc", "1", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("testName"));
    }

    /**
     * Тест для редактирования заявки.
     */
    @Test
    public void whenEditThenTrackerHasEditedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription2", 2);
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test3", "testDescription3", "3", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getDescription(), is("testDescription3"));
    }

    /**
     * Тест для удаления заявки.
     */
    @Test
    public void whenDeletePreviousThenTrackerHasNextValue() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 1);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 2);
        tracker.add(next);
        Input input = new StubInput(new String[]{"3", previous.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getDescription(), is("testDescription2"));
    }

    /**
     * Тест для поиска заявки по Id.
     */
    @Test
    public void whenFindByIdThenTrackerHasFindValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test11", "testDescription11", 11);
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getCreate(), is(11L));
    }

    /**
     * Тест для поиска заявки по имени.
     */
    @Test
    public void whenFindByNameThenTrackerHasFindValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test15", "testDescription15", 15);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test15"));
    }
}