package Manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name(("new")))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }


    public void removeContact() {
        openContactPage();
        click(By.name("selected[]"));
        click(By.name("delete"));
        click(By.linkText("home"));

    }



    public void createContact(ContactData contactData) {

        openContactPage();
        click(By.linkText("add new"));
        type(By.name("firstname"), contactData.firstname());
        type(By.name("middlename"), contactData.middlename());
        type(By.name("lastname"), contactData.lastname());
        click(By.name("submit"));
        click(By.linkText("home"));

    }


}
