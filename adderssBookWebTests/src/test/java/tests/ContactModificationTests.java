package tests;

import model.GroupData;
import modelContact.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact(){
        if (!app.contacts().isContactPresent()) {
            app.contacts().CreateContact(new ContactData().withLastName("Only lastname"));
        }

        app.contacts().modifyContact(new GroupData().withName("modified name"));
    }


}
