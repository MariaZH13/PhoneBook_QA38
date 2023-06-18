package tests;

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
        String email="marzh@com",password="Qwe1234$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
 //       Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));


    }
       @Test
      public void loginNegativeTestWrongPass(){
       String email="marzh@com",password="Qwe1234";
       app.getUser().openLoginForm();
       app.getUser().fillLoginForm(email,password);
       app.getUser().submitLogin();

      }

    //    @Test
//    public void loginPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//
//        // fill login form
//       WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//       emailInput.click();
//       emailInput.clear();
//       emailInput.sendKeys("marzh@com");
//
//       WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//       passInput.click();
//       passInput.clear();
//       passInput.sendKeys("Qwe1234$");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//        // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() >= 0);
//        pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//
//
//    }

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

    @AfterMethod
    public void tearDown(){


    }


}