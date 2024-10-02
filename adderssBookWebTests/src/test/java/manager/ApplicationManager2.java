package manager;

import modelContact.contactData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager2 {

    protected  WebDriver driver;
    private loginHelper2 session2;

    public void init() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1806, 962));
            session2.login("admin", "seret");
        }
    }

    public loginHelper2 session2(){
        if( session2 == null){
            session2 = new loginHelper2(this);
        }
        return session2;
    }


    public boolean isElementPresent(By locator) {
      try{
        driver.findElement(locator);
        return true;
      } catch (NoSuchElementException exception){
        return false;
      }

    }

    public void createContact(contactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("home")).sendKeys(contact.home());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys(contact.work());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys(contact.email2());
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys(contact.email3());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void openContactsPage() {
      if (! isElementPresent(By.linkText("home"))){
        driver.findElement(By.linkText("home"));
      }
    }

    public boolean isContactPresent() {
      return isElementPresent(By.name("selected[]"));
    }

    public  void RemoveContact() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.cssSelector (".left > input")).click();
      driver.findElement(By.linkText("home page")).click();
    }
}
