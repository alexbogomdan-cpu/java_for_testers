package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GroupCreationsTests extends TestBase {

    public static List<String> groupNameProvider() {
        var result = new ArrayList<String>();// создаем пустой список
        for (int i = 0; i < 5; i++ ){//цикл для повторяния действия,которое в фигурных скобках
            result.add(randomString(i * 10));
        }
        return result;

    }

    @ParameterizedTest// создали параметролизованный тест
    @ValueSource(strings = {"group name","group name'"})
    public void CanCreateGroup(String name) {
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        TestBase.app.groups().createGroup(new GroupData(name, "test", "test"));//создаем новую группу
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount + 1,newGroupCount);
    }


//    @Test
//    public void CanCreateGroup() {
//        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));//создаем новую группу
//        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        Assertions.assertEquals(groupCount + 1,newGroupCount);
//    }


    @Test
    void canCreateGroupWithEmtyName() {
        TestBase.app.groups().createGroup(new GroupData());
    }

    @Test
    void canCreateGroupWithNameOnly() {
        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
    }

    @ParameterizedTest
    @MethodSource("groupNameProvider")
    public void CanCreateMultiplelGroup(String name) {
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        app.groups().createGroup(new GroupData(name, "test", "test"));//создаем новую группу
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount + 1,newGroupCount);
    }


//    @Test
//    public void CanCreateMultiplelGroup() {
//        int n = 5;
//        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        for (int i = 0; i < n; i++ ){//цикл для повторяния действия,которое в фигурных скобках
//            app.groups().createGroup(new GroupData(randomString(i * 10), "test", "test"));//создаем новую группу
//        }
//        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        Assertions.assertEquals(groupCount + n,newGroupCount);
//    }

}

