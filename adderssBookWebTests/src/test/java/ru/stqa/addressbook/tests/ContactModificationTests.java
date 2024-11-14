package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.modelContact.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact(){
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withLastName("Only lastname"));
        }
        var oldContacts =  app.hbm().getContactList();
        var rnd=new Random();
        var index =rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withLastName("modified name").withFirstname("modified firstname");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts =  app.hbm().getContactList();
        var expectedList= new ArrayList<>(oldContacts);
        expectedList.set(index,testData.withId(oldContacts.get(index).id()).withLastName("modified name"));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);



    }


}
