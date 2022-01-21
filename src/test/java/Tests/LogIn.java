package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
    // declaram variabila web driver
    public WebDriver driver;

    @Test
    public void login(){
        // setam driverul de chrome
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        // deschidem o instanta de chrome
        driver=new ChromeDriver();
        //accesam un URL
        driver.get("http://demo.automationtesting.in/Index.html");
        // facem driverul in modul maximized
        driver.manage().window().maximize();

        WebElement signInElement= driver.findElement(By.id("btn1"));
        signInElement.click();
       WebElement emailElement= driver.findElement(By.cssSelector("input[placeholder='E mail']")) ;
       String emailvalue= "mari98carmen@yahoo.com";
       emailElement.sendKeys(emailvalue);
       String passwordvalue= "Maricarmen";
       WebElement passwordElement= driver.findElement(By.cssSelector("input[placeholder='Password']"));
       passwordElement.sendKeys(passwordvalue);
       WebElement enterElement= driver.findElement(By.id("enterbtn"));
       enterElement.click();
       WebElement invalidmsg= driver.findElement(By.id("errormsg"));
       String expectedmessage= "Invalid User Name or PassWord";
       String actualmessage= invalidmsg.getText();
        Assert.assertEquals("textul cautat nu este correct",expectedmessage,actualmessage);
      //  driver.close();
        //diferenta dintre close si quit, quit=inchidem toate taburile
        //close inchise doar tab-ul curent
    }
}
