package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {

    public static WebDriver driver;

    private String string;
    private Properties properties;
    private SessionHelper SessionHelper;
    private HttpSessionHelper httpSessionHelper;
    private JamesCliHelper jamesCliHelper;
    private MailHelper mailHelper;
    private RegisterBrowser registerBrowser;


    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties=properties;
    }

    public WebDriver driver(){
        if (driver==null){

            if ("firefox".equals(string)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(string)){
                driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s",string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseURL"));
            driver.manage().window().setSize(new Dimension(945, 979));
        }
        return driver;
    }

    public SessionHelper session(){
        if (SessionHelper==null){
            SessionHelper= new SessionHelper(this);
        }
        return SessionHelper;
    }


    public HttpSessionHelper http() {
        if (httpSessionHelper==null){
            httpSessionHelper= new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }



    public JamesCliHelper jamesCli() {

        if (jamesCliHelper==null){
            jamesCliHelper= new JamesCliHelper(this);
        }
        return jamesCliHelper;
    }

    public MailHelper mail() {

        if (mailHelper==null){
            mailHelper= new MailHelper(this);
        }
        return mailHelper;
    }

    public RegisterBrowser registerBrowser() {

        if (registerBrowser==null){
            registerBrowser= new RegisterBrowser(this);
        }
        return registerBrowser;
    }


    public String property(String name){
        return properties.getProperty(name);
    }

}
