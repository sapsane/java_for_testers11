package tests;

import modelContact.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {


    @Test

    public void canCreateContact() {
     //   app.contacts().openContactsPage();
        app.contacts().createContact(new ContactData("First name", "Last name", "Address", "+74951234567", "+79011234567", "+79021234567", "test1@mail.ru", "test2@mail.ru", "test3@mail.ru"));

    }

    @Test
    public void canCreateContactwithemptyFields() {

        app.contacts().createContact(new ContactData());

    }

    @Test
    public void canCreateContactWithOnlyFirstName() {


        app.contacts().createContact(new ContactData().withFirstname("Only first name"));

    }

    @Test
    public void canCreateContactWithOnlyLastName() {


        app.contacts().createContact(new ContactData().withLastName("Only last name"));

    }
}


