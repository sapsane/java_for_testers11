package manager;

import org.openqa.selenium.By;




public class loginHelper extends HelperBase {

  //  private final ApplicationManager manager;

    public loginHelper(ApplicationManager manager) {
      //  this.manager = manager;
        super(manager);
    }

    void login(String user, String password) {
        type(By.name("user"),user);
        type(By.name("pass"),password);
        click(By.xpath("//input[@value=\'Login\']"));
      //  manager.driver.findElement(By.name("user")).sendKeys(user);
      //  manager.driver.findElement(By.name("pass")).sendKeys(password);

      //  manager.driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }
}
