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

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData(name, header, footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {//цикл для повторяния действия,которое в фигурных скобках
            result.add(new GroupData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));//добавляем объекты типа GroupDate со случано сгенерированным name,header,footer
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultiplelGroup(GroupData group) {//создали тест,который имеет один параметр ввиде обьекта GroupDate
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        app.groups().createGroup(group);//создаем новую группу, которая передается в качестве параметров тестируемой функции
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount + 1,newGroupCount);
    }




    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("group name'","","")));// создаем пустой список
        return result;

    }
    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CanNotCreateGroup(GroupData group) {//создали тест,который имеет один параметр ввиде обьекта GroupDate
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        app.groups().createGroup(group);//создаем новую группу, которая передается в качестве параметров тестируемой функции
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount ,newGroupCount);//сравниваем количество груп до и после
    }


//    @ParameterizedTest// создали параметролизованный тест
//    @ValueSource(strings = {"group name","group name'"})
//    public void CanCreateGroup(String name) {
//        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        TestBase.app.groups().createGroup(new GroupData(name, "test", "test"));//создаем новую группу
//        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        Assertions.assertEquals(groupCount + 1,newGroupCount);
//    }


//    @Test
//    public void CanCreateGroup() {
//        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));//создаем новую группу
//        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        Assertions.assertEquals(groupCount + 1,newGroupCount);
//    }


//    @Test
//    void canCreateGroupWithEmtyName() {
//        TestBase.app.groups().createGroup(new GroupData());
//    }
//
//    @Test
//    void canCreateGroupWithNameOnly() {
//        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
//    }

//    @ParameterizedTest
//    @MethodSource("groupNameProvider")
//    public void CanCreateMultiplelGroup(String name) {
//        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        app.groups().createGroup(new GroupData(name, "test", "test"));//создаем новую группу
//        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        Assertions.assertEquals(groupCount + 1,newGroupCount);
//    }





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

