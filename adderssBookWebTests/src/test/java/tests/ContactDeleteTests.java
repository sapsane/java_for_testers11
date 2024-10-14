package tests;

import modelContact.ContactData;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDeleteTests extends TestBase {


    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {

            app.contacts().createContact(new ContactData("", "test", "test", "test", "test", "test", "test", "test", "test", "test"));
        }
        List<ContactData> oldContacts = app.contacts().getList();
        var rnd=new Random();
        var index =rnd.nextInt(oldContacts.size());
        app.contacts().removeContact();
        List<ContactData> newContacts = app.contacts().getList();
        Assertions.assertEquals(newContacts.size(),oldContacts.size()-1);
    }

}
