package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertBranch extends SharedData {

    @Test
    public void TestAutomat() {

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        SkipsignIn.click();

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(SwitchTo).perform();

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        AlertsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> AlerOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        AlerOptions.get(0).click();

        WebElement AlertOk = driver.findElement(By.cssSelector("#OKTab>button"));
        AlertOk.click();

        Alert Ok= driver.switchTo().alert();
        Ok.accept();

        AlerOptions.get(1).click();
            WebElement OkCancell= driver.findElement(By.cssSelector("#CancelTab>button"));
        OkCancell.click();
        Alert Cancel= driver.switchTo().alert();
        Cancel.dismiss();

        OkCancell.click();
        Cancel.accept();

        AlerOptions.get(2).click();
        WebElement TextboXalert= driver.findElement(By.cssSelector("#Textbox>button"));
        TextboXalert.click();
        Alert Text= driver.switchTo().alert();
        Text.sendKeys("Buna Prieteni");


        Text.accept();


    }


}
