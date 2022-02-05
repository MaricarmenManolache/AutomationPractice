package Tests;

import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.EditorKit;

public class LogIn {
    //Declaram variabila webdriver

    public WebDriver driver;

    public ElementMethods elementMethods;

    @Test
    public void login(){
        elementMethods= new ElementMethods(driver);
        //Setam driverul de chrome
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        //deschidem o instanta de chrome
        driver= new ChromeDriver();
        //accesam un url
        driver.get("http://demo.automationtesting.in/Index.html");
        //facem driverul in modul maximise
        driver.manage().window().maximize();

        WebElement signinElement=driver.findElement(By.id("btn1"));
        signinElement.click();

        WebElement emailelement=driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailvalue="maricarmen@gmail.com";
        emailelement.sendKeys(emailvalue);

        WebElement passwordelement=driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordvalue="44d22";
        passwordelement.sendKeys(passwordvalue);

        WebElement enterelement=driver.findElement(By.id("enterbtn"));
        enterelement.click();

        WebElement errormsgelement=driver.findElement(By.id("errormsg"));
       elementMethods.validationElementText(errormsgelement, "Invalid User Name or PassWord");
        //quit=inchide instanta cu toate taburile deschise
        //close= inchide tabul curent
        driver.close();
    }

}

