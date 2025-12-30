package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {

        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("test", "test", "test"));
        }
        int groupCount = app.groups().getCount();//Подсчитываем колличество груп переред созданием
        app.groups().removeGroup();
        int newGroupCount = app.groups().getCount();//подсчитываем коллчичество груп после добавления группы
        Assertions.assertEquals(groupCount - 1,newGroupCount);//сравниваем колличество груп до и после

    }
    @Test//тест для удаления всех групп
    void canRemoveAllGroupsOnce(){
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("test", "test", "test"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());


    }


}

