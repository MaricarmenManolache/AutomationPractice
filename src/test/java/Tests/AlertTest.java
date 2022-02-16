package Tests;

import Base.SharedData;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertTest extends SharedData {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    private AlertMethods alertMethods;
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public AlertPage alertPage;

    @Test
    public void TestAutomat() {

        elementMethods= new ElementMethods(driver);
       pageMethods= new PageMethods(driver);
       alertMethods= new AlertMethods(driver);
       indexPage = new IndexPage(driver);
       registerPage= new RegisterPage(driver);
       alertPage= new AlertPage(driver);

       indexPage.clickSkipSignIn();
       registerPage.goToAlertPage();
       alertPage.AlertsProcess("buna dimineata");
    }
}
