package Tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase {

    @Test
    public void CanCreationContact() {
        TestBase.app.contacs().createContact(new ContactData());
    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact name")) {
            for (var middlename : List.of("", "contact header")) {
                for (var lastname : List.of("", "contact footer")) {
                    result.add(new ContactData().withFirstname(firstname).withMiddlename(middlename).withLastname(lastname));
                }
            }
        }
        for (int i = 0; i < 5; i++) {//цикл для повторяния действия,которое в фигурных скобках
            result.add(new ContactData()
                    .withFirstname(randomString(i * 10))
                    .withMiddlename(randomString(i * 10))
                    .withLastname(randomString(i * 10)));//добавляем объекты типа ContactDate со случано сгенерированным name,header,footer
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultiplelGroup(ContactData contact) {//создали тест,который имеет один параметр ввиде обьекта ContactData
        int contactCount = app.contacs().getCount();//Подсчитываем колличество контактов переред созданием
        app.contacs().createContact(contact);//создаем новый контакт, который передается в качестве параметров тестируемой функции
        int newContactCount = app.contacs().getCount();//подсчитываем коллчичество контактов после добавления группы
        Assertions.assertEquals(contactCount + 1,newContactCount);
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultiplelContact(ContactData contact) {
        var oldContacts = app.contacs().getList();// возвращает список объектов типа ContactData
        app.contacs().createContact(contact);//создаем новый contact, которая передается в качестве параметров тестируемой функции
        var newContact = app.contacs().getList();// возвращает список объектов типа ContactData после создания
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
            newContact.sort(compareById);//сортируем списки по возрастанию идентификаторов
            var expectedList = new ArrayList<>(oldContacts);
            expectedList.add(contact.withId(newContact.get(newContact.size() - 1).id()).withFirstname("").withLastname(""));//берем идентификатор последнего элемента
            expectedList.sort(compareById);//сортируем списки по возрастанию идентификаторов
            Assertions.assertEquals(newContact, expectedList);//сравниваем два списка







    }




//    @ParameterizedTest
//    @MethodSource("groupProvider")
//    public void CanCreateMultiplelGroup(GroupData group) {//создали тест,который имеет один параметр ввиде обьекта GroupDate
//        var oldGroups = app.groups().getList();// возвращает список объектов типа GroupData
//        //int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
//        app.groups().createGroup(group);//создаем новую группу, которая передается в качестве параметров тестируемой функции
//        var newGroups = app.groups().getList();// возвращает список объектов типа GroupData после удаления
//        Comparator<GroupData> compareById = (o1, o2) -> {// компаратор
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));// функция для сравнения двух чисел и эти числа в данном случае идентификаторы групп
//        };
//        newGroups.sort(compareById);//сортируем списки по возрастанию идентификаторов
//        var expectedList = new ArrayList<>(oldGroups);
//        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));//берем идентификатор последнего элемента
//        expectedList.sort(compareById);//сортируем списки по возрастанию идентификаторов
//        Assertions.assertEquals(newGroups, expectedList);//сравниваем два списка
//
//        //int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
//        //Assertions.assertEquals(groupCount + 1,newGroupCount);
//    }




}
