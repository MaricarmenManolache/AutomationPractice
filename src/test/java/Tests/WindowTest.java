package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.WindowMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public WindowMethods windowMethods;
    public ElementMethods elementMethods;
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public WindowPage windowPage;
    @Test
        public void testAutomat() {
        indexPage= new IndexPage(driver);
        registerPage= new RegisterPage(driver);
        windowPage= new WindowPage(driver);

        indexPage.clickSkipSignIn();
        registerPage.goToWindowPage();
        windowPage.wholeTabWindowProcess();
    }
}
