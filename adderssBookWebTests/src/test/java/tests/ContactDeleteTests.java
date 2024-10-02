package tests;

import manager.ApplicationManager;
import modelContact.ContactData2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactDeleteTests extends TestBase {


    @Test
    public void canRemoveContact() {
        //app.contacts().openContactsPage();
        if (!app.contacts().isContactPresent()) {
            ApplicationManager.driver.findElement(By.linkText("home")).click();
            app.contacts().CreateContact(new ContactData2("test", "test", "test", "test", "test", "test", "test", "test", "test"));
        }
        app.contacts().RemoveContact();
    }

}
