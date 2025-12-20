import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.groups().createGroup(new GroupData("test", "test", "test"));
    }


    @Test
    void canCreateGroupWithEmtyName () {
        app.groups().createGroup(new GroupData());
    }
    @Test
    void canCreateGroupWithNameOnly () {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

}

