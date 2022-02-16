package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.PageMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class RegisterTest extends SharedData {
    //daca avem mai multe elemente cu acelasi nume, le diferentiem prin parinte "form>"
    public IndexPage indexPage;
    public RegisterPage registerPage;

    @Test
    public void RegisterTest() {
        indexPage= new IndexPage(driver);
        registerPage= new RegisterPage(driver);

        indexPage.clickSkipSignIn();
        registerPage.registerValidProcess("Maricarmen", "Manolache", "Floresti", "maricarmen.manolache@gmail.com","0753603027",
                "English","Java", "Australia", "1998", "July","7", "C:\\Users\\manol\\OneDrive\\Imagini\\Peliculă\\1.jpg","Mari12",
                "Mari12");
    }
}