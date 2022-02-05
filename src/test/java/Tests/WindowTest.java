package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.WindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public WindowMethods windowMethods;
    public ElementMethods elementMethods;
    @Test
        public void testAutomat() {
        windowMethods=new WindowMethods(driver);

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        SkipsignIn.click();

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(SwitchTo).perform();

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        AlertsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowsOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        WindowsOptions.get(0).click();

        WebElement ClickBtn= driver.findElement(By.cssSelector("#Tabbed>a>button"));
        ClickBtn.click();

       windowMethods.switchTOTab(1);

        driver.close();
        windowMethods.switchTOTab(0);

        WindowsOptions.get(1).click();

        WebElement ButonClick= driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        ButonClick.click();

        windowMethods.switchTOTab(1);

        driver.close();
        windowMethods.switchTOTab(0);

        WindowsOptions.get(2).click();

        WebElement Click3= driver.findElement(By.cssSelector("button[onclick='multiwindow()']"));
        Click3.click();

      windowMethods.switchTOTab(2);

        windowMethods.closeCurrentTab();
       windowMethods.switchTOTab(1);

       windowMethods.closeCurrentTab();
       windowMethods.switchTOTab(0);




    }
}
