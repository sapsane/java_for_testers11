import modelContact.contactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBaseContact {


    @Test
    public void canCreateContact() {
        openContactsPage();
        createContact(new contactData("First name1", "Last name1", "Address1", "+74951234567", "+79011234567", "+79021234567", "test1@mail.ru", "test2@mail.ru", "test3@mail.ru"));

    }

    @Test
    public void canCreateContactWithEmptyField() {
        openContactsPage();
        createContact(new contactData());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        openContactsPage();
        createContact(new contactData().withName("NameOnly"));
    }

}
