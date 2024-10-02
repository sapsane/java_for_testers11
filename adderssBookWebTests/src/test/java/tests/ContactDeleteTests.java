package tests;

import manager.ApplicationManager;
import modelContact.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactDeleteTests extends TestBase {


    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            ApplicationManager.driver.findElement(By.linkText("home")).click();
            app.contacts().CreateContact(new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test"));
        }
        app.contacts().RemoveContact();
    }

}
