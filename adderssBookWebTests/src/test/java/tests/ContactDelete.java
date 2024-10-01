package tests;

import modelContact.contactData;
import org.junit.jupiter.api.Test;

public class ContactDelete extends TestBaseContact {

  @Test
  public void canDeleteContact() {
    app2.openContactsPage();
    if (!app2.isContactPresent()) {
      app2.createContact(new contactData("firstname", "lastname", "address", "home", "mobile", "work", "email", "email2", "email3"));
    }
    app2.RemoveContact();

  }

}
