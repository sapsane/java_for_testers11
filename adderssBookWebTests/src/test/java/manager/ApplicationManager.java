package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    public static WebDriver driver;
  //  protected  WebDriver driver;
    private loginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;


    public loginHelper session(){
        if( session == null){
            session=new loginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null){
            groups = new GroupHelper (this);
        }
        return groups;
    }

    public ContactHelper contacts() {
        if (contacts == null){
            contacts = new ContactHelper (this);
        }
        return contacts;
    }


   public void init(String browser) {
        if (driver == null) {
         if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)){
                    driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s",browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(945, 979));
            session().login("admin", "secret" );

        }
    }


    public boolean isElementPresent(By locator) {
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

    //-------------------------------------------------------------

}
