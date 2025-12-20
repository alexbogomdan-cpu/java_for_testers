import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        createGroup("test");
    }


    @Test
    void canCreateGroupWithEmtyName () {
        openGroupsPage();
        createGroup("");
    }
}

