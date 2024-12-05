package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.Comparator;

public class ContactsAddToGroupTests extends TestBase{
    @Test
    void canContactAddToGroup(){

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
// берем полный список контактов
        var ListContacts = app.hbm().getContactList();
//берем группу №=0
        var group = app.hbm().getGroupList().get(0);

//берем список контактов в группе№=0
        var ListGroupContacts = app.hbm().getContactsInGroup(group);
//сортируем списки
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        ListContacts.sort(compareById);
        ListGroupContacts.sort(compareById);
//если списки ListContacts ListGroupContacts равны групп и контактов
        if(ListContacts.size()==ListGroupContacts.size()) {
            //создаем новый контакт

            app.contacts().openContactsPage2();
            app.hbm().createContact(new ContactData("", "AUTOtestNew", "AUTOtestNEW", "test", "test", "test", "test", "test", "test", "test", ""));
            app.contacts().openContactsPage2();
            //создали
        }
        // берем полный список контактов
        var ListContactsNew = app.hbm().getContactList();

        //берем группу №=0
        var groupNew = app.hbm().getGroupList().get(0);

        //берем список контактов в группе№=0
        var ListGroupContactsNew = app.hbm().getContactsInGroup(groupNew);
        //сортируем списки
        Comparator<ContactData> compareById3 = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        ListContactsNew.sort(compareById3);
        ListGroupContactsNew.sort(compareById3);




        //добавляем новый контакт в группу
        if(ListContactsNew.size()!=ListGroupContactsNew.size()){
            //удаляем теперь из полного списка контактов нужно удалить те, которые входят в эту группу,
            ListContactsNew.removeAll(ListGroupContactsNew);
            var contactNew=ListContactsNew.get(0);
            var oldRelated2 = app.hbm().getContactsInGroup(groupNew);
            app.contacts().openContactsPage2();
            //добавляем в группу
            app.contacts().contactsAddToGroup(contactNew, groupNew);
            var newRelated2 = app.hbm().getContactsInGroup(groupNew);



            var expectedList = oldRelated2;
            expectedList.add(contactNew);

            Comparator<ContactData> compareById2 = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            newRelated2.sort(compareById2);
            expectedList.sort(compareById2);

            Assertions.assertEquals(newRelated2,expectedList);


        }


     /*
            //если списки ListContacts ListGroupContacts не равны групп и контактов
            //удаляем теперь из полного списка контактов нужно удалить те, которые входят в эту группу,

            ListContacts.removeAll(ListGroupContacts);
            // останутся контакты, которые в неё не входят.
            // берём любой из них.
            var contact=ListContacts.get(0);

            var oldRelated = app.hbm().getContactsInGroup(group);
            //добавляем в группу
            app.contacts().openContactsPage2();
            app.contacts().contactsAddToGroup(contact, group);

            var newRelated = app.hbm().getContactsInGroup(group);

            var expectedList = oldRelated;
            expectedList.add(contact);

            Comparator<ContactData> compareById1 = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            newRelated.sort(compareById1);
            expectedList.sort(compareById1);

            Assertions.assertEquals(newRelated,expectedList);


        */













/*

        //------------------------------------------------------------------------------------------------------------------------
        //предусловия
        if (app.hbm().getContactCount()==0) {
            app.hbm().createContact(new ContactData("", "AUTOtest", "AUTOtest", "test", "test", "test", "test", "test", "test", "test", ""));
            app.contacts().openContactsPage2();
        }

        if (app.hbm().getGroupCount()==0) {
            app.hbm().createGroup(new GroupData("", "group AUTO name", "group header", "Group footer"));
            app.groups().openGroupsPage();
        }

    //добавление контакта в группу
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
*/


    }


}
