package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase{
    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "test", "test", "test"));
        }
        var oldGroups = app.groups().getList();// возвращает список объектов типа GroupData
        var rnd = new Random();//генератор случайных чисел
        var index = rnd.nextInt(oldGroups.size());// выбираем индекс в диапазоне от 0 до Group.size
        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.groups().getList();// возвращает список объектов типа GroupData после удаления
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {// компаратор
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));// функция для сравнения двух чисел и эти числа в данном случае идентификаторы групп
        };
        newGroups.sort(compareById);//сортируем списки по возрастанию идентификаторов
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);//сравниваем реальный список с ожидаемым
    }



}
