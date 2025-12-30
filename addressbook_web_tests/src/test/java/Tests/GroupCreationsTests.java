package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));//создаем новую группу
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount + 1,newGroupCount);
    }


    @Test
    void canCreateGroupWithEmtyName() {
        TestBase.app.groups().createGroup(new GroupData());
    }

    @Test
    void canCreateGroupWithNameOnly() {
        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
    }


    @Test
    public void CanCreateMultiplelGroup() {
        int n = 5;
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        for (int i = 0; i < n; i++ ){//цикл для повторяния действия,которое в фигурных скобках
            app.groups().createGroup(new GroupData(randomString(i*10), "test", "test"));//создаем новую группу
        }
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount + n,newGroupCount);
    }

}

