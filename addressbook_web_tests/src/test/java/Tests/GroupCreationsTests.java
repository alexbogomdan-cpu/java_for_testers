package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));
    }


    @Test
    void canCreateGroupWithEmtyName () {
        TestBase.app.groups().createGroup(new GroupData());
    }
    @Test
    void canCreateGroupWithNameOnly () {
        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
    }

}

