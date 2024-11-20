package ru.stqa.addressbook.manager;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.ContactRecord;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;


    public HibernateHelper(ApplicationManager manager)   {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
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


    private static GroupRecord convertGroups(GroupData data) {
        var id = data.id();
        if ("".equals(id)){
            id="0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
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
        return new ContactData("" + record.id, record.firstname, record.lastname, record.address, record.home, record.mobile, record.work, record.email, record.email2, record.email3);
    }

    private static ContactRecord convertContacts(ContactData data) {
        var id = data.id();
        if ("".equals(id)){
            id="0";
        }
        return new ContactRecord( Integer.parseInt(id), data.firstname(), data.lastname(), data.address(), data.home(), data.mobile(), data.work(), data.email(), data.email2(), data.email3());
    }


    public List<ContactData> getContactList(){
        return convertListContact(sessionFactory.fromSession (session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));

    }


    public long getGroupCount() {
        return sessionFactory.fromSession (session -> {
            return session.createQuery("select count(*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertGroups(groupData));
            session.getTransaction().commit();
        });
    }

    public Long getContactCount() {
        return sessionFactory.fromSession (session -> {
            return session.createQuery("select count(*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertContacts(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return  sessionFactory.fromSession(session -> {
               return convertListContact(session.get(GroupRecord.class, group.id()).contacts);
        });
    }
}



