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

        var oldContacts = app.contacts().getList();
        var rnd=new Random();
        var index =rnd.nextInt(oldContacts.size());

        app.contacts().removeContact(oldContacts.get(index));

        var newContacts = app.contacts().getList();
        var expectedList= new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts,expectedList);
    }

}
