package Tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {
    @Test
    public void canRemovalContact() {

        if (!TestBase.app.contacs().isContactPresent()) {
            TestBase.app.contacs().createContact(new ContactData("asdasd", "awadad", "jdsnsd"));

        }

        TestBase.app.contacs().removeContact();
    }



}
