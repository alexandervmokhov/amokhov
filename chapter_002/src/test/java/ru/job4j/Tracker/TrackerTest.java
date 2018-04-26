package ru.job4j.Tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    /**
     * Тест для добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Тест для замены заявки.
     * Алгоритм работы:
     * Добавляем заявку в трекер. Теперь в объект проинициализирован id.
     * Создаем новую заявку.
     * Проставляем старый id из previous, который был сгенерирован выше.
     * Обновляем заявку в трекере.
     * Проверяем, что заявка с таким id имеет новое имя test2.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест для удаления заявки.
     *
     */
    @Test
    public void whenDeleteFirstNameThenReturnSecondName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription1",123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        tracker.delete(first.getId());
        assertThat(tracker.getAll()[0], is(second));
    }

    /**
     * Тест для получения массива по имени.
     */
    @Test
    public void whenAddNewNameThenTrackerHasSameListOfNames() {
        Tracker tracker = new Tracker();
        Item item = new Item("Ivan","testDescription",123L);
        tracker.findByName("Ivan");
        assertThat(tracker.findByName(item.getName()), is("Ivan"));
    }
}