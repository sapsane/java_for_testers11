package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.modelContact.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactDeleteTests extends TestBase {


    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount()==0) {

            app.hbm().createContact(new ContactData("", "test", "test", "test", "test", "test", "test", "test", "test", "test", ""));
            app.contacts().openContactsPage2();
        }

        var oldContacts =  app.hbm().getContactList();
        var rnd=new Random();
        var index =rnd.nextInt(oldContacts.size());


        app.contacts().removeContact(oldContacts.get(index));

        var newContacts =  app.hbm().getContactList();
        var expectedList= new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts,expectedList);
    }

}
