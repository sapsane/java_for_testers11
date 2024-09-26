package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected  WebDriver driver;
    private loginHelper session;
    private GroupHelper groups;

    public void inint(String browser) {
        if (driver == null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)){
                    driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s",browser));
            }

          //  driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));


            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1806, 962));
            session().login("admin", "secret" );
        }
    }

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

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}