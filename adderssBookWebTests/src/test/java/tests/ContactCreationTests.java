package tests;

import modelContact.contactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBaseContact {


    @Test
    public void canCreateContact() {
        app2.openContactsPage();
        app2.createContact(new contactData("First name1", "Last name1", "Address1", "+74951234567", "+79011234567", "+79021234567", "test1@mail.ru", "test2@mail.ru", "test3@mail.ru"));

    }

    @Test
    public void canCreateContactWithEmptyField() {
        app2.openContactsPage();
        app2.createContact(new contactData());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app2.openContactsPage();
        app2.createContact(new contactData().withName("NameOnly"));
    }

}
