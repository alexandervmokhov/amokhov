package ru.job4j.tracker;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 14.05.2018
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    //private final PrintStream stdout = System.out;
    private Tracker tracker = new Tracker();

    @Before
    public void loadTracker() {
        System.out.println("execute before method");
        tracker = this.tracker;
    }

    //@After
    //public void backOutput() {
     //   System.setOut(this.stdout);
     //   System.out.println("execute after method");
    //}

    /**
     * Тест для вывода всех заявок.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 1);
        this.tracker.add(first);
        Item second = new Item("test2", "testDescription2", 2);
        tracker.add(second);
        Input input = new StubInput(new String[]{"1", "6"});
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * Тест для редактирования заявки.
     */
    @Test
    public void whenEditThenTrackerHasEditedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription2", 2);
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test3", "testDescription3", "3", "6"});
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
        Input input = new StubInput(new String[]{"3", previous.getId(), "6"});
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
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
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
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test15"));
    }
}
