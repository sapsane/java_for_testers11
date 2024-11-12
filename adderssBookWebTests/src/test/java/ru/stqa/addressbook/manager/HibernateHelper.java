package ru.stqa.addressbook.manager;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;


    public HibernateHelper(ApplicationManager manager)   {
        super(manager);
        sessionFactory = new Configuration()
                //    .addAnnotatedClass(Book.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertListGroups(List<GroupRecord> records){
        List<GroupData> result = new ArrayList<>();
        for (var record : records){
            result.add(convertGroups(record));
        }
        return result;
    }


    private static GroupData convertGroups(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    public List<GroupData> getGroupList(){
        return convertListGroups(sessionFactory.fromSession (session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
                }));

        }


    static List<ContactData> convertListContact(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertContacts(record));
        }
        return result;

    }

    private static ContactData convertContacts(ContactRecord record) {
        return new ContactData("" + record.id, record.firstname, record.lastname, record.address, record.home, record.mobile, record.work, record.email, record.company, record.email3);
    }


    public List<ContactData> getContactList(){
        return convertListContact(sessionFactory.fromSession (session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));

    }


}


