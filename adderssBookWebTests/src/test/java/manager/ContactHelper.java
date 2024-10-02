package manager;

import model.GroupData;
import modelContact.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper (ApplicationManager manager) {
        //this.manager=manager;
        super(manager);
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void CreateContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        click(By.xpath("//body"));
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());

        submitContactCreation();
        returnToContactPage();
    }



    public void RemoveContact() {
        openContactsPage();
        selectContact();
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

    public void modifyContact(GroupData modifiedContact) {
        openContactsPage();
        selectContact();
        initContactModification();
        //fillContactForm(modifiedContact);
        submitContactModyfication();
        returnToContactPage();
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    private void submitContactModyfication() {
        click(By.name("update"));
    }


    private void initContactModification() {
        click(By.xpath("(//img[@alt=\'Edit\'])"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

}
