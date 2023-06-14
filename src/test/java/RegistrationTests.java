import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("marzh"+ i + "@com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Qwe1234$");

        wd.findElement(By.xpath("//button[2]")).click();

 //       Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "marzh"+ i + "com",password = "Qwe1234$";
        openLoginForm();
        fillLoginForm(email,password);
        submitRegistration();

    }

    @Test
    public void registrationNegativeWrongPass(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "marzh"+ i + "@.com",password = "Qwe1234";
        openLoginForm();
        fillLoginForm(email,password);
        submitRegistration();
    }


    @AfterMethod
    public void tearDown(){

    }
}
