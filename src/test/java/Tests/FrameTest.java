package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.FrameMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {
       public FrameMethods frameMethods;
       public ElementMethods elementMethods;
    @Test
    public void testAutomat(){
        frameMethods= new FrameMethods(driver);
        elementMethods= new ElementMethods(driver);
        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(SkipsignIn);

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        frameMethods.switchtoFrame(SwitchTo);

        WebElement AlertsElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        elementMethods.clickElement(AlertsElement);

        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        frameMethods.switckToFramebyID("singleframe");
        WebElement Input= driver.findElement(By.cssSelector("input[type='text']"));
        elementMethods.fillElement(Input,"Henlo");

        frameMethods.switchToDefault();

        WebElement Frames= driver.findElement(By.cssSelector("li>a[href='#Multiple']"));
        elementMethods.clickElement(Frames);

        frameMethods.switckToFramebyElement(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));

        frameMethods.switckToFramebyElement(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        WebElement Text= driver.findElement(By.cssSelector("input[type='text']"));
        elementMethods.fillElement(Text,"Test");


    }
}
