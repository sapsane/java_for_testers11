package tests;

import modelContact.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();


        for (var firstname : List.of("","First Name1") ){
            for (var lastname : List.of("","lastname")){
                for (var address : List.of("","address")) {
                    result.add(new ContactData().withFirstname(firstname)
                                .withLastName(lastname)
                                .withAddress(address)
                                .withHome("home")
                                .withMobile("mobile")
                                .withWork("work")
                                .withEmail("email")
                                .withEmail2("email2")
                                .withEmail3("email3"));
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            result.add(new ContactData()
                    .withFirstname(randomString(i*10))
                    .withLastName(randomString(i*10))
                    .withAddress(randomString(i*10))
                    .withHome(randomString(i*10))
                    .withMobile(randomString(i*10))
                    .withWork(randomString(i*10))
                    .withEmail(randomString(i*10))
                    .withEmail2(randomString(i*10))
                    .withEmail3(randomString(i*10)) );
        }
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


    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact ) {

        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount+1,newContactCount);
    }

    @ParameterizedTest
    @MethodSource("NegativecontactProvider")
    public void canNotCreateContact(ContactData contact ) {

        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount,newContactCount);
    }

}


