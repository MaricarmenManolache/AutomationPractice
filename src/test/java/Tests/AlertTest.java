package Tests;

import Base.SharedData;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
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

    @Test
    public void TestAutomat() {

        elementMethods= new ElementMethods(driver);
       pageMethods= new PageMethods(driver);
       alertMethods= new AlertMethods(driver);

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(SkipsignIn);

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementMethods.moveToElement(SwitchTo);

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        elementMethods.clickElement(AlertsElement);

        pageMethods.navigateToURL("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> AlerOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        AlerOptions.get(0).click();

        WebElement AlertOk = driver.findElement(By.cssSelector("#OKTab>button"));
        elementMethods.clickElement(AlertOk);

            //wait explicit
        alertMethods.waitAlert();
        //thread sleep
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alertMethods.acceptAlert();


        AlerOptions.get(1).click();
        WebElement OkCancell= driver.findElement(By.cssSelector("#CancelTab>button"));
        elementMethods.clickElement(OkCancell);
        alertMethods.cancelAlert();


        AlerOptions.get(2).click();
        WebElement TextboXalert= driver.findElement(By.cssSelector("#Textbox>button"));
        TextboXalert.click();
        alertMethods.acceptFillALert("Buna ziua prieteni");


    }
}
