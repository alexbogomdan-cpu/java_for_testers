package Tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
    @Test
    public void canRemovalContact() {
        if (app.contacs().getCount() == 0) {
            app.contacs().createContact((new ContactData("", "asdasd", "awadad", "jdsnsd")));
        }
        var oldContacts = app.contacs().getList();// возвращает список объектов типа ContactData
        var rnd = new Random();//генератор случайных чисел
        var index = rnd.nextInt(oldContacts.size());// выбираем индекс в диапазоне от 0 до Contact.size
        app.contacs().removeContact(oldContacts.get(index));
        var newContacts = app.contacs().getList();// возвращает список объектов типа ContactData после удаления
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts.size(),oldContacts.size() - 1);//сравниваем размер списка до и после
        Assertions.assertEquals(newContacts,expectedList);//сравниваем реальный список с ожидаемым

        TestBase.app.contacs().removeContact(oldContacts.get(index));
    }



}
