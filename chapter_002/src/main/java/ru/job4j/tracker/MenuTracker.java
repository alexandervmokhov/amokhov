package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод, инициилизирующий события
     */
    public void fillActions() {
        this.actions[position++] = new MenuTracker.AddItem(0, "Add the new item.");
        this.actions[position++] = new MenuTracker.ShowItems(1, "Show all items.");
        this.actions[position++] = new MenuTracker.EditItem(2, "Edit item.");
        this.actions[position++] = new MenuTracker.DeleteItem(3, "Delete item.");
        this.actions[position++] = new MenuTracker.FindById(4, "Find item by Id.");
        this.actions[position++] = new MenuTracker.FindByName(5, "Find items by name.");
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);

    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний статический класс реализующий добавление новой
     * заявки в хранилище.
     */
    class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- New item adding menu -----------");
            String name = input.ask("Enter query name: ");
            String desc = input.ask("Enter description of query: ");
            long create = Long.parseLong(input.ask("Enter new long number: "));
            Item item = new Item(name, desc, create);
            tracker.add(item);
            System.out.println("------------ New item with Id: " + item.getId() + " added. --------");
        }
    }

    /**
     * Внутренний статический класс реализующий вывод на экран всех заявок.
     */
    class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(
                            String.format(
                                    "%s. %s. %s. %s",
                                    item.getId(),
                                    item.getName(),
                                    item.getDescription(),
                                    item.getCreate()
                            )
                    );
                }
            }
        }
    }

    /**
     * Внутренний статический класс реализующий замену заявки в хранилище.
     */
    class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- New query replacing menu -----------");
            String id = input.ask("Enter query ID: ");
            Item previous = tracker.findById(id);
            System.out.println("Current query name is: " + tracker.findById(id).getName());
            String name = input.ask("Enter new query name: ");
            String desc = input.ask("Enter new query description: ");
            long create = Long.parseLong(input.ask("Enter new long number: "));
            Item next = new Item(name, desc, create);
            next.setId(previous.getId());
            tracker.replace(previous.getId(), next);
            System.out.println("------------ This query: " + tracker.findById(id).getName() + " was changed. --------");
            System.out.println("------------ It has ID: " + next.getId() + "  --------");
        }
    }

    /**
     * Внутренний статический класс реализующий удаление заявки из хранилища.
     */
    class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Query deleting menu -----------");
            String id = input.ask("Enter query ID: ");
            System.out.println("Deletind query name is: " + tracker.findById(id).getName());
            tracker.delete(id);
            System.out.println("------------ This query was deleted --------");
        }
    }

    /**
     * Внутренний статический класс реализующий поиск заявки по Id.
     */
    class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Query finding menu -----------");
            String id = input.ask("Enter query ID: ");
            System.out.print("Founded query is: " + id + ", ");
            System.out.print(tracker.findById(id).getName() + ", ");
            System.out.println(tracker.findById(id).getDescription());
        }
    }

    /**
     * Внутренний статический класс реализующий поиск заявки по имени.
     */
    class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Query finding -----------");
            String name = input.ask("Enter query name: ");
            for (int i = 0; i < tracker.findByName(name).length; i++) {
                if (tracker.findByName(name)[i] != null
                        && name != null
                        && tracker.findByName(name)[i].getName().equals(name)) {
                    System.out.println(
                            String.format(
                                    "%s. %s. %s. %s",
                                    tracker.findByName(name)[i].getId(),
                                    tracker.findByName(name)[i].getName(),
                                    tracker.findByName(name)[i].getDescription(),
                                    tracker.findByName(name)[i].getCreate()
                            )
                    );
                }
            }
        }
    }
}