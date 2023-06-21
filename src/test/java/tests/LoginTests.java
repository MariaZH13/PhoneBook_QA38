package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {



    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }

    @Test
    public void loginPositiveTestBase(){
        User user = new User().withEmail("marzh@com").withPassword("Qwe1234$");
 //       String email="marzh@com",password="Qwe1234$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));


    }
       @Test
      public void loginNegativeTestWrongPass(){
        User user = new User().withEmail("marzh@com").withPassword("Qwe1234");

       app.getUser().openLoginForm();
       app.getUser().fillLoginForm(user);
       app.getUser().submitLogin();


      }

        @Test
    public void loginPositiveTest(){
        User user = new User().withEmail("marzh@com").withPassword("Qwe1234$");

        // open login form
        app.getUser().openLoginForm();

        // fill login form
       app.getUser().fillLoginForm(user);

        // click on button Login
        app.getUser().submitLogin();

        // Assert
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));


    }

 //   @Test
 //   public void loginNegativeTestWrongEmail(){
  //      wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    //      WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
  //      emailInput.click();
  //      emailInput.clear();
  //      emailInput.sendKeys("marzhcom");

  //      WebElement passInput = wd.findElement(By.xpath("//input[2]"));
  //      passInput.click();
  //      passInput.clear();
  //      passInput.sendKeys("Qwe1234$");

 //       wd.findElement(By.xpath("//button[1]")).click();

        //Assert
 //   }

}
