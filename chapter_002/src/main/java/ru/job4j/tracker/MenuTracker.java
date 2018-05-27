package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод, инициилизирующий события
     */
    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindById();
        this.actions[5] = new MenuTracker.FindByName();
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
     * Внутренний статический класс реализующий добавление новой заявки в хранилище.
     */
    private static class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- New item adding menu -----------");
            String name = input.ask("Enter query name: ");
            String desc = input.ask("Enter description of query: ");
            long create = Long.parseLong(input.ask("Enter new long number: "));
            Item item = new Item(name, desc, create);
            tracker.add(item);
            System.out.println("------------ New item with Id: " + item.getId() + " added. --------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Внутренний статический класс реализующий вывод на экран всех заявок.
     */
    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }

    }

    /**
     * Внутренний статический класс реализующий замену заявки в хранилище.
     */
    private static class EditItem implements UserAction {
        public int key() {
            return 2;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * Внутренний статический класс реализующий удаление заявки из хранилища.
     */
    private static class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Query deleting menu -----------");
            String id = input.ask("Enter query ID: ");
            System.out.println("Deletind query name is: " + tracker.findById(id).getName());
            tracker.delete(id);
            System.out.println("------------ This query was deleted --------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Внутренний статический класс реализующий поиск заявки по Id.
     */
    private static class FindById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Query finding menu -----------");
            String id = input.ask("Enter query ID: ");
            System.out.print("Founded query is: " + id + ", ");
            System.out.print(tracker.findById(id).getName() + ", ");
            System.out.println(tracker.findById(id).getDescription());
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    /**
     * Внутренний статический класс реализующий поиск заявки по имени.
     */
    private static class FindByName implements UserAction {
        public int key() {
            return 5;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }
    }
}