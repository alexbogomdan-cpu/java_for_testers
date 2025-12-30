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

}

