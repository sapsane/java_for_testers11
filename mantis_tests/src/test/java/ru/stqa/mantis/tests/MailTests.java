package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class MailTests extends TestBase{
    @Test
    void canDrainInbox(){
        app.mail().drain("user1@localhost","password");
    }


    @Test
    void canReceiveEmail(){
        //получаем почту
        var messages=app.mail().receive("user1@localhost","password", Duration.ofSeconds(60));
        Assertions.assertEquals(1,messages.size());
        System.out.println(messages);
    }
    @Test
    void canExtractURL(){
        //извлекаем ссылку из письма
        var messages=app.mail().receive("user1@localhost","password", Duration.ofSeconds(120));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()){
            var url= text.substring(matcher.start(),matcher.end());
            System.out.println(url);
        }

    }
//----------------------------------------
    @Test
    void canUserRegisterTests(String username){
        var email= String.format("%s@localhost",username);
        //создать пользователя адресс на почтовом сервере (JamesHelper)
        //заполняем форму создания и отправляем (браузер)
        //получаем почту   (mailHelper)
        //извлекаем ссылку из письма
        //проходим по ссылке и завершаем регистрацию пользователя (браузер)
        //проверяем что пользователь может залогиниться (httpSessionHelper)


    }










}
