package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить, что массив data имеет первые элементы
        // одинаковые с value

        for (int i = 0; i < value.length; i++) { //выбираем длину value,
                                                 // как наиболее короткую
            if (data[i] != value[i]) {
                result = false; // в случае нахождения несоответствия
                                // возвращаем ложь
            }
            continue;
        }
        return result;  // результат возвращается только если все первые
                        // элементы в обеих массивах равны
    }
}
