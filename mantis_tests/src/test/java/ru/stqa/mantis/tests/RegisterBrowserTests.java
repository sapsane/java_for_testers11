package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.manager.ApplicationManager;

public class RegisterBrowserTests extends TestBase {

    @Test
    void  canRegisterBrowserTests (){

       var user="user2";
       var email="user2@localhost";
     app.registerBrowser().registrationWeb(user,email);
    }

    @Test
    void clickOnTheLink() {
        var link ="http://localhost/mantisbt-2.25.2/verify.php?id=6&confirm_hash=QcQOFqfsSd_vEptRlIs80dFznNKOYHjKZqfiJtND7Y24NeTuTfjPAb1G6ofYyloZxSjXstpVx3wLlliX5wTc";
               // "http://localhost/mantisbt-2.25.2/verify.php?id=3&confirm_hash=Rg1jHI0c-P0D34VqdDryvjP7G4aS6AIW9OcsoUeaR-TBRDyskCu9tiVnyqzmFNG7wdyQOKqFwWvemrRyQfmk";
        app.registerBrowser().clickOnLink(link,"user101");
    }
}
