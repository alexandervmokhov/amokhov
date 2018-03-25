package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        //int[] data мы объявили переменную массива

        //public int indexOf(int ch, int fromIndex) — возвращает индекс
        // в данной строке первого вхождения указанного символа, начиная
        // поиск по указанному индексу, или значение -1, если символ не
        // встречается.

        int rsl = -1; // Если элемента нет в массиве, то возвращаем -1.
        // Общая форма цикла for each:
        // for (тип и название: название массива/коллекции) {

        for (int index : data) {
            if (data[index] == el) {
                rsl = index;

                break;
            }
        }
        return rsl;
    }
}