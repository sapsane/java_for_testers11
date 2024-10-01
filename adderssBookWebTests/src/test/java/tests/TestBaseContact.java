package tests;

import manager.ApplicationManager2;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseContact {
    protected static ApplicationManager2 app2;


    @BeforeEach
    public  void setUp() {
       if (app2 ==null){
            app2 =new ApplicationManager2();
            }

        app2.init();


    }

}
