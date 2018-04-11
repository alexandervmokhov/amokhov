package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar2 {
    private char[] data;

    public ArrayChar2(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param origin слово целиком.
     * @param sub часть слова.
     * @return если слово целиком содержит часть слова.
     */
    public boolean contains(String origin, String sub) {
        boolean result = true;
        char[] value = sub.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i+1] != value[i]) {
                result = false;
            }
        }
        return result;
    }
}
