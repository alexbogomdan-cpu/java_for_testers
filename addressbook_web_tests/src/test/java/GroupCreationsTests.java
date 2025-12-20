import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.createGroup("test", "test", "test");
    }


    @Test
    void canCreateGroupWithEmtyName () {
        app.openGroupsPage(GroupCreationsTests.this);
        app.createGroup("", "", "");
    }
}

