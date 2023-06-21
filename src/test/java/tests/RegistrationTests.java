package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("marzh"+i+"@gmail.com").withPassword("Qwe1234$");
 //       String email = "marzh"+i+"@gmail.com",password = "Qwe1234$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("marzh"+ i + "com").withPassword("Qwe1234$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();

    }

    @Test
    public void registrationNegativeWrongPass(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("marzh"+ i + "@.com").withPassword("Qwe1234");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
    }

        @Test
    public void registrationPositiveAddition(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("marzh"+ i + "@gmail.com").withPassword("Qwe1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

}
