package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.modelContact.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();


//        for (var firstname : List.of("","First Name1") ){
//            for (var lastname : List.of("","lastname")){
//                for (var address : List.of("","address")) {
//                    result.add(new ContactData().withFirstname(firstname)
//                                .withLastName(lastname)
//                                .withAddress(address)
//                                .withHome("home")
//                                .withMobile("mobile")
//                                .withWork("work")
//                                .withEmail("email")
//                                .withEmail2("email2")
//                                .withEmail3("email3"));
//                }
//            }
//        }


//        for (int i = 0; i < 3; i++) {
//            result.add(new ContactData()
//                    .withFirstname(CommonFunctions.randomString(i*10))
//                    .withLastName(CommonFunctions.randomString(i*10))
//                    .withAddress(CommonFunctions.randomString(i*10))
//                    .withHome(CommonFunctions.randomString(i*10))
//                    .withMobile(CommonFunctions.randomString(i*10))
//                    .withWork(CommonFunctions.randomString(i*10))
//                    .withEmail(CommonFunctions.randomString(i*10))
//                    .withEmail2(CommonFunctions.randomString(i*10))
//                    .withEmail3(CommonFunctions.randomString(i*10)) );
//        }

        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);

        return result;
    }



    public static List<ContactData> NegativecontactProvider() {
        var result = new ArrayList<ContactData>(List.of(

                new ContactData("", "First Name2'","","","","","","","","")));

        return result;
    }
/*
    @ParameterizedTest
    @ValueSource (strings={"First Name1","First2 Name'"})
    public void canCreateContact(String name) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData(name, "Last name", "Address", "+74951234567", "+79011234567", "+79021234567", "test1@mail.ru", "test2@mail.ru", "test3@mail.ru"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount+1,newContactCount);
    }

 */
/*
    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());
    }


 */
    /*
    @Test
    public void canCreateContactWithOnlyFirstName() {
        app.contacts().createContact(new ContactData().withFirstname("Only first name"));
    }


     */
   /*
    @Test
    public void canCreateContactWithOnlyLastName() {
        app.contacts().createContact(new ContactData().withLastName("Only last name"));
    }

    */
        public static List<ContactData> singleRandomContact() {
            return List.of(new ContactData()
                        .withFirstname(CommonFunctions.randomString(10))
                        .withLastName(CommonFunctions.randomString(10))
                        .withAddress(CommonFunctions.randomString(10))
                        .withHome(CommonFunctions.randomString(10))
                        .withMobile(CommonFunctions.randomString(10))
                        .withWork(CommonFunctions.randomString(10))
                        .withEmail(CommonFunctions.randomString(10))
                        .withEmail2(CommonFunctions.randomString(10))
                        .withEmail3(CommonFunctions.randomString(10)));
        }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateMultipleContacts(ContactData contact ) {

        //var oldContacts = app.contacts().getList();
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var maxId=newContacts.get(newContacts.size()-1).id();

        var expectedList= new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);

    }

    @ParameterizedTest
    @MethodSource("NegativecontactProvider")
    public void canNotCreateContact(ContactData contact ) {


        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Assertions.assertEquals(newContacts,oldContacts);


    }

}


