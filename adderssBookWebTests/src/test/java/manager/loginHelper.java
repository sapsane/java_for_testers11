package manager;

import org.openqa.selenium.By;




public class loginHelper extends helperBase {



    public loginHelper (ApplicationManager manager) {
        super(manager);
    }

    void login(String user, String password) {
        type(By.name("user"),user);
        type(By.name("pass"),password);
        click(By.xpath("//input[@value=\'Login\']"));
    }


}
