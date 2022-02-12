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
        elementMethods= new ElementMethods(driver);

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(SkipsignIn);

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(SwitchTo).perform();

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        elementMethods.clickElement(AlertsElement);

        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowsOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        elementMethods.clickElement(WindowsOptions.get(0));

        WebElement ClickBtn= driver.findElement(By.cssSelector("#Tabbed>a>button"));
        elementMethods.clickElement(ClickBtn);

        windowMethods.switchTOTab(1);

        driver.close();
        windowMethods.switchTOTab(0);

        elementMethods.clickElement(WindowsOptions.get(1));

        WebElement ButonClick= driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        elementMethods.clickElement(ButonClick);

        windowMethods.switchTOTab(1);

        driver.close();
        windowMethods.switchTOTab(0);

        elementMethods.clickElement(WindowsOptions.get(2));

        WebElement Click3= driver.findElement(By.cssSelector("button[onclick='multiwindow()']"));
       elementMethods.clickElement(Click3);

        windowMethods.switchTOTab(2);

        windowMethods.closeCurrentTab();
        windowMethods.switchTOTab(1);

        windowMethods.closeCurrentTab();
        windowMethods.switchTOTab(0);




    }
}
