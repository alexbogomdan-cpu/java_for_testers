package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {

        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "test", "test", "test"));
        }
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием

        var oldGroups = app.groups().getList();// возвращает список объектов типа GroupData
        var rnd = new Random();//генератор случайных чисел
        var index = rnd.nextInt(oldGroups.size());// выбираем индекс в диапазоне от 0 до Group.size
        app.groups().removeGroup(oldGroups.get(index));// удаляем группу именно эту группу
        var newGroups = app.groups().getList();// возвращает список объектов типа GroupData после удаления
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount - 1,newGroupCount);//сравниваем колличество груп до и после
        Assertions.assertEquals(newGroups.size(),oldGroups.size() - 1);//сравниваем размер списка до и после
        Assertions.assertEquals(newGroups,expectedList);//сравниваем реальный список с ожидаемым

    }
    @Test//тест для удаления всех групп
    void canRemoveAllGroupsOnce(){
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "test", "test", "test"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());


    }


}

