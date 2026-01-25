package tests;

import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationsTests extends TestBase {

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {//цикл для повторяния действия,которое в фигурных скобках
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));//добавляем объекты типа GroupDate со случано сгенерированным name,header,footer
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultiplelGroup(GroupData group) {//создали тест,который имеет один параметр ввиде обьекта GroupDate
        var oldGroups = app.groups().getList();// возвращает список объектов типа GroupData
        //int groupCount = app.groups().getCount();//Подсчитываем колличество групп перед созданием
        app.groups().createGroup(group);//создаем новую группу, которая передается в качестве параметров тестируемой функции
        var newGroups = app.groups().getList();// возвращает список объектов типа GroupData после удаления
        Comparator<GroupData> compareById = (o1, o2) -> {// компаратор
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));// функция для сравнения двух чисел и эти числа в данном случае идентификаторы групп
        };
        newGroups.sort(compareById);//сортируем списки по возрастанию идентификаторов
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));//берем идентификатор последнего элемента
        expectedList.sort(compareById);//сортируем списки по возрастанию идентификаторов
        Assertions.assertEquals(newGroups, expectedList);//сравниваем два списка

        //int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        //Assertions.assertEquals(groupCount + 1,newGroupCount);
    }




    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'","","")));// создаем пустой список
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

