package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.Comparator;

public class ContactsAddToGroupTests extends TestBase{
    @Test
    void canContactAddToGroup(){

        if (app.hbm().getContactCount()==0) {
            app.hbm().createContact(new ContactData("", "AUTOtest", "AUTOtest", "test", "test", "test", "test", "test", "test", "test", ""));
            app.contacts().openContactsPage2();
        }

        if (app.hbm().getGroupCount()==0) {
            app.hbm().createGroup(new GroupData("", "group AUTO name", "group header", "Group footer"));
            app.groups().openGroupsPage();
        }


        var contact = app.hbm().getContactList().get(0);
    //      System.out.println("тестКонтакт contact="+contact);
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
    //      System.out.println("тест1 oldRelated="+oldRelated);
        app.contacts().openContactsPage2();
        app.contacts().contactsAddToGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
    //      System.out.println("тест2 newRelated="+newRelated);
        var expectedList = oldRelated;
        expectedList.add(contact);
            //      System.out.println("тест2 expectedList="+expectedList);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated.sort(compareById);
        expectedList.sort(compareById);

        Assertions.assertEquals(newRelated,expectedList);

    }


}
