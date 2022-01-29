package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {

    @Test
    public void testAutomat(){
        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        SkipsignIn.click();

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(SwitchTo).perform();

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        AlertsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("singleframe");

        WebElement Input= driver.findElement(By.cssSelector("input[type='text']"));
        Input.sendKeys("Hello World");

        driver.switchTo().defaultContent();

        WebElement Frames= driver.findElement(By.cssSelector("li>a[href='#Multiple']"));
        Frames.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        WebElement Text= driver.findElement(By.cssSelector("input[type='text']"));
        Text.sendKeys("Hi");


    }
}
