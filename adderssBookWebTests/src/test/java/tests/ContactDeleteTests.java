package tests;

import manager.ApplicationManager;
import modelContact.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactDeleteTests extends TestBase {


    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {

            app.contacts().createContact(new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test"));
        }
        app.contacts().removeContact();
    }

}