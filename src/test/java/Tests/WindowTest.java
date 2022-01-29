package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
        public void testAutomat() {

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

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> Tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        System.out.println("Titlul paginii: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(Tabs.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());

        WindowsOptions.get(1).click();

        WebElement ButonClick= driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        ButonClick.click();

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> Windows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Windows.get(1));
        System.out.println("Titlul ferestrei: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(Windows.get(0));
        System.out.println("Titlul ferestrei: "+driver.getTitle());

        WindowsOptions.get(2).click();

        WebElement Click3= driver.findElement(By.cssSelector("button[onclick='multiwindow()']"));
        Click3.click();

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> MultipleTabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(MultipleTabs.get(1));
        System.out.println("Titlul paginii: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(MultipleTabs.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());

        driver.switchTo().window(MultipleTabs.get(2));
        System.out.println("Titlul paginii: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(MultipleTabs.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());




    }
}
