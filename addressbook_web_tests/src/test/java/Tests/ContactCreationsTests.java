package Tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationsTests extends TestBase {

    @Test
    public void CanCreationContact() {
        TestBase.app.contacs().createContact(new ContactData());
    }



}
