package ru.stqa.colections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollectionTests {

    @Test
    void arrayTests(){
        var array = new String[]{"a","b","c"};//Создаем массив строк
        Assertions.assertEquals("a", array[0]);// Проверяем что строка "а" в массиве
        Assertions.assertEquals(3, array.length);//Проверяем соответствие размера массива

        array[0]="d";// Заменили элемент массива
        Assertions.assertEquals("d", array[0]);

    }
    @Test
    void listTest(){
        var list = new ArrayList<String>();//Создаем список
        Assertions.assertEquals(0, list.size());// Проверяем колличество элементов списка

        list.add("a");//Добавляем элемет в список
        Assertions.assertEquals(1, list.size());
    }
}
