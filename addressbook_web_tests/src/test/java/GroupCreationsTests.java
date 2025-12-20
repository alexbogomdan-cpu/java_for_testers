import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("test", "test", "test"));
    }


    @Test
    void canCreateGroupWithEmtyName () {
        app.openGroupsPage();
        app.createGroup(new GroupData());
    }
    @Test
    void canCreateGroupWithNameOnly () {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }

}

