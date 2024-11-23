package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.tests.TestBase;

public class RegisterBrowser extends HelperBase {


    public RegisterBrowser (ApplicationManager manager){
        super( manager);
    }


    public void registrationWeb(String user, String email){


        click(By.cssSelector("a[href='signup_page.php']"));
        click(By.name("username"));
        type(By.name("username"),user);
        click(By.name("email"));
        type(By.name("email"),email);
        click(By.cssSelector("input[type='submit']"));
    }

    public void clickOnLink(String link,String user){
        manager.driver.get(link);
        click(By.name("realname"));
        type(By.name("realname"),user);

        click(By.name("password"));
        type(By.name("password"),"password");

        click(By.name("password_confirm"));
        type(By.name("password_confirm"),"password");

        click(By.cssSelector("button[type='submit']"));
    }

}
