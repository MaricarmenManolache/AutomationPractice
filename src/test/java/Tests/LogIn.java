package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import Pages.IndexPage;
import Pages.LoginPage;
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

    public IndexPage indexPage;
    public LoginPage loginPage;

    @Test
    public void login(){
       indexPage= new IndexPage(driver);
       loginPage= new LoginPage(driver);

//        //Setam driverul de chrome
//        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
//        //deschidem o instanta de chrome
//        driver= new ChromeDriver();
//        //accesam un url
//        driver.get("http://demo.automationtesting.in/Index.html");
//        //facem driverul in modul maximise
//        driver.manage().window().maximize();

       indexPage.clickSignIn();
       loginPage.loginInvalidProcess("test123@yahoo.com", "test1212", "Invalid User Name or PassWord");
    }

}

