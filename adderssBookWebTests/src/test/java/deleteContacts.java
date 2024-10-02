import modelContact.contactData;
import org.junit.jupiter.api.Test;

public class deleteContacts  extends TestBaseContact {

  @Test
  public void canDeleteContact() {
    openContactsPage();
    if (!isContactPresent()) {
      createContact(new contactData("firstname", "lastname", "address", "home", "mobile", "work", "email", "email2", "email3"));
    }
    RemoveContact();

  }

}
