package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name(("new")))) {
            click(By.linkText("home"));
        }
    }
    public List<ContactData> getList() {
        openContactPage();
        var contacts = new ArrayList<ContactData>();// список
        var tds = manager.driver.findElements(By.cssSelector("tr.entry"));//поиск всех эдементов c  заданным значением атрибута класс
        for (var tr : tds){
            var name = tr.getText();
            var checkbox = tr.findElement(By.name("selected[]"));//поиск checkbox внутри элемента span
            var id = checkbox.getAttribute("value");// у чекбокса берем значение атрибута value
            contacts.add(new ContactData().withId(id).withFirstname(name)); // в список groups добавляем новый объект с заданным именем и индетификатором
        }
        return contacts;
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }


    public void removeContact(ContactData contactData) {
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


    public int getCount() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();//метод для подсчета колличества контактов
    }

    public void modifyContact(ContactData contact,ContactData modifycontact) {
        openContactPage();
        manager.driver.findElement(By.cssSelector("tr:nth-child(4) > .center:nth-child(8) img")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys("popravil");
        manager.driver.findElement(By.cssSelector("input:nth-child(70)")).click();
    }
}
