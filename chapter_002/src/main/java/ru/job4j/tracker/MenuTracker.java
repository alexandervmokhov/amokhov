package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];
    // скорректировать количество пунктов меню пользователя

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод, инициилизирующий события
     */
    public void fillActions() {
        this.actions[0] = new AddItem(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return  0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter query name: ");
            String desc = input.ask("Enter description of query: ");
            long create = Long.parseLong(input.ask("Enter new long number: "));
            tracker.add(new Item(name, desc, create));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }

    }
}
