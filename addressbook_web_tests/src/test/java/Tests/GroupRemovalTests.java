package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {

        if (!TestBase.app.groups().isGroupPresent()) {
            TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));
        }
        TestBase.app.groups().removeGroup();

    }
    @Test
    public void canRemoveGroup2() {

        if (!TestBase.app.groups().isGroupPresent()) {
            TestBase.app.groups().createGroup(new GroupData("test", "test", "test"));
        }
        TestBase.app.groups().removeGroup();

    }

}

