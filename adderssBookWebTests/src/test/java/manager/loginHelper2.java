package manager;

import org.openqa.selenium.By;

public class loginHelper2 {

    private final ApplicationManager2 manager2;

    public loginHelper2 (ApplicationManager2 manager2) {
        this.manager2 = manager2;
    }

    void login(String user, String password ) {
        manager2.driver.findElement(By.name("user")).sendKeys(user);
        manager2.driver.findElement(By.name("pass")).sendKeys(password);
        manager2.driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }
}

