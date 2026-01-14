package Tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact(){
        if (app.contacs().getCount() == 0) {
            app.contacs().createContact(new ContactData());
        }
        var oldConacts = app.contacs().getList();// возвращает список объектов типа GroupData
        var rnd = new Random();//генератор случайных чисел
        var index = rnd.nextInt(oldConacts.size());// выбираем индекс в диапазоне от 0 до Group.size
        var testData = new ContactData().withFirstname("modified name");
        app.contacs().modifyContact(oldConacts.get(index), testData);
        var newContacts = app.contacs().getList();// возвращает список объектов типа GroupData после удаления
        var expectedList = new ArrayList<>(oldConacts);
        expectedList.set(index, testData.withId(oldConacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {// компаратор
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));// функция для сравнения двух чисел и эти числа в данном случае идентификаторы групп
        };
        newContacts.sort(compareById);//сортируем списки по возрастанию идентификаторов
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);//сравниваем реальный список с ожидаемым
    }
}
