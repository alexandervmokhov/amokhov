package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate для выполнения задания
 * "5.6. Удаление дубликатов в массиве. [#225]".
 *
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 * @version $Id$
 * @since 04.04.2018
 */
public class ArrayDuplicate {
    public String[] remove(String[] array){
        // Суть алгоритма в том, что найденный дубликат меняется местами
        // с элементом в конце массива (со сдвигом к началу
        // на количество найденных дубликатов), при этом храним счетчик
        // перемещенных дубликатов. while нам помогает в ситуации если мы
        // хотим свапнуть два одинаковых элемента, первое его условие
        // защищает от выхода за границы массива.

        int dup = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length - dup; j++){
                if(array[i].equals(array[j])){
                    while(j != array.length - dup - 1
                            && array[array.length - dup - 1].equals(array[j])){
                        dup++;
                    }
                    String tmp = array[array.length - dup - 1];
                    array[array.length - dup - 1] = array[j];
                    array[j] = tmp;
                    dup++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dup);
    }
}