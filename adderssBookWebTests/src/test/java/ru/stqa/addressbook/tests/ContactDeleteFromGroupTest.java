package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.Comparator;

public class ContactDeleteFromGroupTest extends TestBase {
    @Test
    void canContactDeleteFromGroup(){

        //предусловия
        if (app.hbm().getContactCount()==0) {
            //добавление контакта, если не было
            app.hbm().createContact(new ContactData("", "AUTOtest", "AUTOtest", "test", "test", "test", "test", "test", "test", "test", ""));
            app.contacts().openContactsPage2();
        }

        if (app.hbm().getGroupCount()==0) {
            //добавление группы, если не было
            app.hbm().createGroup(new GroupData("", "group AUTO name", "group header", "Group footer"));
            app.groups().openGroupsPage();
        }


        //удаление
        app.contacts().openContactsPage2();
        var contact2 = app.hbm().getContactList().get(0);
        var group2 = app.hbm().getGroupList().get(0);
        var oldRelated2 = app.hbm().getContactsInGroup(group2);
        if (oldRelated2.size() ==0){
            //добавление контакта в группу
            var contact = app.hbm().getContactList().get(0);
            var group = app.hbm().getGroupList().get(0);
            app.contacts().openContactsPage2();
            app.contacts().contactsAddToGroup(contact, group);

        }
        app.contacts().openContactsPage2();
        oldRelated2 = app.hbm().getContactsInGroup(group2);
        //удаление контакта
        app.contacts().contactsDeleteToGroup(contact2, group2);
        //проверки
        var newRelated2 = app.hbm().getContactsInGroup(group2);
        var expectedList2 = oldRelated2;
        expectedList2.remove(contact2);
        Comparator<ContactData> compareById2 = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated2.sort(compareById2);
        expectedList2.sort(compareById2);

        Assertions.assertEquals(newRelated2,expectedList2);
    }

}
