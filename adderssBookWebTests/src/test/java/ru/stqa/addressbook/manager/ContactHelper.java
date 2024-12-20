package ru.stqa.addressbook.manager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        //this.manager=manager;
        super(manager);
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
            click(By.linkText("home"));
        }
    }
    public void openContactsPage2() {

            click(By.linkText("home"));

    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }


    public void removeContact(ContactData contact) {
        openContactsPage();
        selectContact(contact);
        removedSelectedContact();
        returnToContactPage();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }


    private void initContactCreation() {
        click(By.linkText("add new"));
    }


    private void removedSelectedContact() {
        click(By.cssSelector(".left > input"));
    }

    public void modifyContact(ContactData contact,ContactData modifiedContact) {
        openContactsPage();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModyfication();
        returnToContactPage();
    }

    private void fillContactForm(ContactData modifiedContact) {
        click(By.xpath("//body"));
        type(By.name("firstname"), modifiedContact.firstname());
        type(By.name("lastname"), modifiedContact.lastname());
        type(By.name("address"), modifiedContact.address());
        type(By.name("home"), modifiedContact.home());
        type(By.name("mobile"), modifiedContact.mobile());
        type(By.name("work"), modifiedContact.work());
        type(By.name("email"), modifiedContact.email());
        type(By.name("email2"), modifiedContact.email2());
        type(By.name("email3"), modifiedContact.email3());
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    private void submitContactModyfication() {
        click(By.name("update"));
    }


    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("[href='edit.php?id=%s']",contact.id())));
    }

    private void selectContact(ContactData contact) {
      //  click(By.name("selected[]"));
        click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts = new ArrayList<ContactData>();
        var row = manager.driver.findElements(By.cssSelector("tr"));
        for (var row2 : row) {
            var cells = row2.findElements(By.tagName("td"));
            if (!(cells.size()== 0)) {
                var checkBox = cells.get(0).findElement(By.name("selected[]"));
                var id  = checkBox.getAttribute("value");
                var lastname = cells.get(1).getText();
                var firstname = cells.get(2).getText();
                contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastName(lastname));
            }
        }
        return contacts;
    }


    public void contactsAddToGroup(ContactData contact, GroupData group) {
        openContactsPage();
        selectContact(contact);
        click(By.name("to_group"));
        selectGroup(group);
        click(By.name("add"));
    }

    private void selectGroup(GroupData group) {
       new Select( manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    public void contactsDeleteToGroup(ContactData contact, GroupData group) {
        openContactsPage();
        ContactsInGroupPage(group);
        selectContact(contact);
        click(By.name("remove"));
    }

    private void ContactsInGroupPage(GroupData group) {
        new Select( manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }


    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[6]",contact.id()))).getText();

    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[5]",contact.id()))).getText();

    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[4]",contact.id()))).getText();
    }


}



