package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTest extends TestBase{

    @Test
    //void canUserRegisterTests(String username){
    void canUserRegisterTests ()    {

       var username= "user10";
       // var username = CommonFunctions.randomString(8);
       // System.out.println("Имя пользователя= "+ username);
        var email1= String.format("%s@localhost",username);
        app.jamesCli().addUser(email1,"password");

        //создать пользователя адресс на почтовом сервере (JamesHelper)
        //заполняем форму создания и отправляем (браузер)
        //получаем почту   (mailHelper)
        //извлекаем ссылку из письма
        //проходим по ссылке и завершаем регистрацию пользователя (браузер)
        //проверяем что пользователь может залогиниться (httpSessionHelper)


        //заполняем форму создания и отправляем (браузер)
        app.registerBrowser().registrationWeb(username,email1);

        //получаем почту
        var messages=app.mail().receive(email1,"password", Duration.ofSeconds(120));
        Assertions.assertEquals(1,messages.size());
        System.out.println(messages);
        //удаляем письмо
        app.mail().drain(email1,"password");

        //извлекаем ссылку из письма

        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()){
            var url= text.substring(matcher.start(),matcher.end());
            System.out.println(url);
            app.registerBrowser().clickOnLink(url,username);
        }
        app.http().login(username,"password");
        Assertions.assertTrue(app.http().isLoggedIn());





      }







    }
