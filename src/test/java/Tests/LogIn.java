package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.EditorKit;

public class LogIn extends SharedData {
    //Declaram variabila webdriver

//    public WebDriver driver;

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;
    @Test
    public void login(){
        elementMethods= new ElementMethods(driver);
        pageMethods= new PageMethods(driver);
        windowMethods= new WindowMethods(driver);

//        //Setam driverul de chrome
//        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
//        //deschidem o instanta de chrome
//        driver= new ChromeDriver();
//        //accesam un url
//        driver.get("http://demo.automationtesting.in/Index.html");
//        //facem driverul in modul maximise
//        driver.manage().window().maximize();

        WebElement signinElement=driver.findElement(By.id("btn1"));
        elementMethods.clickElement(signinElement);

        WebElement emailelement=driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        elementMethods.fillElement(emailelement, "maricarmen.manolache@gmail.com");

        WebElement passwordelement=driver.findElement(By.cssSelector("input[placeholder='Password']"));
        elementMethods.fillElement(passwordelement,"121212");

        WebElement enterelement=driver.findElement(By.id("enterbtn"));
        elementMethods.clickElement(enterelement);

        WebElement errormsgelement=driver.findElement(By.id("errormsg"));
        elementMethods.validationElementText(errormsgelement, "Invalid User Name or PassWord");
        //quit=inchide instanta cu toate taburile deschise
        //close= inchide tabul curent
        driver.close();
    }

}

