package Tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContactCreationsTests extends TestBase {

    @Test
    public void CanCreationContact() {
        TestBase.app.contacs().createContact(new ContactData());
    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "group name")) {
            for (var middlename : List.of("", "group header")) {
                for (var lastname : List.of("", "group footer")) {
                    result.add(new ContactData(firstname, middlename, lastname));
                }
            }
        }
        for (int i = 0; i < 5; i++) {//цикл для повторяния действия,которое в фигурных скобках
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));//добавляем объекты типа ContactDate со случано сгенерированным name,header,footer
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




}
