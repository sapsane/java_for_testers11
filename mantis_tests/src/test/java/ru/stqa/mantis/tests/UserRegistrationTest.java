package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.CreateUserData;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTest extends TestBase{

    @Test
    //void canUserRegisterTests(String username){
    void canUserRegisterTests ()    {

      // var username= "user10";
        var username = CommonFunctions.randomString(8);
       // System.out.println("Имя пользователя= "+ username);
        var email1= String.format("%s@localhost",username);
        //1-создать пользователя адресс на почтовом сервере (JamesHelper)
        //2-заполняем форму создания и отправляем (браузер)
        //3-получаем почту   (mailHelper)
        //4-извлекаем ссылку из письма
        //5-проходим по ссылке и завершаем регистрацию пользователя (браузер)
        //6-проверяем что пользователь может залогиниться (httpSessionHelper)

        app.jamesApi().addUser(email1,"password");

      //заполняем форму создания и отправляем (браузер)
      //  app.registerBrowser().registrationWeb(username,email1);

      //api регистрация пользователя

        app.rest().createUser(new CreateUserData()
                .withUsername(username)
                .withEmail(email1)
                .withPassword("password")
                .withRealName(username));

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
        }else {
            throw  new RuntimeException("No mail");
        }
        app.http().login(username,"password");
        Assertions.assertTrue(app.http().isLoggedIn());





      }

    }
