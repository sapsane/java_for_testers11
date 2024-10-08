package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager)   {
        super(manager);
    }

   public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }



    public  void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        click(By.xpath("//label[contains(.,\'Group name:\')]"));
        fillGroupForm(group);
        submitGroupGreation();
        //manager.driver.findElement(By.linkText("group page")).click();
        returnToGroupsPage();
    }



    public   void removeGroup() {
        openGroupsPage();
        selectGroup();
        //manager.driver.findElement(By.name("selected[]")).click();
        removeSelectedGroups();
        // manager.driver.findElement(By.linkText("group page")).click();
        returnToGroupsPage();
    }
    
    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        sudmitGroupModification();
        returnToGroupsPage();
    }



    private void submitGroupGreation() {
        click(By.name("submit"));
    }



    private void initGroupCreation() {
        click(By.name("new"));
    }



    private void removeSelectedGroups() {
        click(By.name("delete"));
    }



    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void sudmitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
      //  click(By.xpath("//label[contains(.,\'Group header (Logo):\')]"));
        type(By.name("group_header"), group.header());
     //   click(By.xpath("//label[contains(.,\'Group footer (Comment):\')]"));
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }
}
