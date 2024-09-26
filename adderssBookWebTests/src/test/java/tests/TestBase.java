package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app==null){
            app=new ApplicationManager();
        }
        app.inint(System.getProperty("browser","firefox"));

    }

}
