package manager;

import model.GroupData;
import modelContact.ContactData;
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

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
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


    public void removeContact() {
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

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var row = manager.driver.findElements(By.cssSelector("tr"));
        for (var row2 : row) {
            var cells = row2.findElements(By.tagName("td"));
            if (!(cells.size()== 0)) {

                var array = new String[8];
                var i = 0;


                for (var cels2 : cells) {
                    array[i] = cels2.getText();
                    var test = cels2.getText();
                    var test2 = cels2.getText();
                    if (i == 0) {
                        var checkBox = cels2.findElement(By.name("selected[]"));
                        array[i] = checkBox.getAttribute("value");

                    }
                    i = i + 1;
                }
                var id = array[0];
                var lastname = array[1];
                var firstname = array[2];
                contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastName(lastname));
            }


            //  var checkBox = td.findElement(By.name("selected[]"));
            //  var id = checkBox.getAttribute("value");
            //  contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastName(lastname));
        }
        return contacts;
    }


}



