package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class TestBase {
    protected static ApplicationManager app;

    // protected WebDriver driver;

   /* @BeforeEach
    public void setUp() {
        if (app==null){
            app=new ApplicationManager();
        }
        app.init(System.getProperty("browser","firefox"));

    }
*/

    @BeforeEach
    public void setUp() {
        if (app==null){
            app=new ApplicationManager();
        }
        app.init();
    }


    /*
    public boolean isElementPresent(By locator) {
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

 */
}
