package Manager;

import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name(("new")))) {
            click(By.linkText("groups"));
        }
    }

//    public boolean isGroupPresent() {
//        openGroupsPage();
//        return manager.isElementPresent(By.name("selected[]"));
//    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        click(By.name("new"));
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
        click(By.name("submit"));
        click(By.linkText("groups"));
    }

    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupPage();
    }

    public void modifyGroup(GroupData group, GroupData modifydGroup) {
        openGroupsPage();
        selectGroup(group);
        initGroupModification();
        fillGroupForm(modifydGroup);
        submitGroupModification();
        returnToGroupPage();
    }


    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    private void selectGroup(GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']",group.id())));//
    }

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }


    public int getCount() {
        openGroupsPage();// открываем страницу групп
        return manager.driver.findElements(By.name("selected[]")).size();//метод для подсчета колличества групп

    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {//функция для выбора всех груп
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox: checkboxes) {
            checkbox.click();
        }
    }

    public List<GroupData> getList() {
        openGroupsPage();
        var groups = new ArrayList<GroupData>();// список
        var spans = manager.driver.findElements(By.cssSelector("span.group"));//поиск всех эдементов c  заданным значением атрибута класс
        for (var span : spans){
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));//поиск checkbox внутри элемента span
            var id = checkbox.getAttribute("value");// у чекбокса берем значение атрибута value
            groups.add(new GroupData().withId(id).withName(name)); // в список groups добавляем новый объект с заданным именем и индетификатором
        }
        return groups;
    }



    private void fillGroupForm(GroupData modifiedGroup) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys("testi");
    }


    private void submitGroupModification() {
        click(By.linkText("Update"));
    }

    private void initGroupModification() {
        click(By.linkText("Edit group"));
    }
}
