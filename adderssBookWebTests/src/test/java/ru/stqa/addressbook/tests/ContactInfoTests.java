package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhonesAddressEmails () {
        //список предусловий потому что список контактов может быть пустым
        if (app.hbm().getContactCount()==0) {
            app.hbm().createContact(new ContactData("", "AUTOtest", "AUTOtest", "test1", "test2", "test3", "test4", "test5", "test6", "test7","test8"));
            app.contacts().openContactsPage2();
        }

        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);

        var phones= app.contacts().getPhones(contact);
        var expected1 = Stream.of(contact.home(),contact.mobile(),contact.work(),contact.secondary())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));

        var emails= app.contacts().getEmails(contact);
        var expected2 = Stream.of(contact.email(),contact.email2(),contact.email3())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));

        var address= app.contacts().getAddress(contact);
        var expected3 = Stream.of(contact.address())
                //.filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));


        Assertions.assertEquals(expected1,phones);
        Assertions.assertEquals(expected2,emails);
        Assertions.assertEquals(expected3,address);

    }


    }
