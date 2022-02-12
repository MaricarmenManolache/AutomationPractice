package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }


    public void switckToFramebyID(String value) {
        waitFrame(value);
    }

    public void waitFrame(String value) {
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(value));

    }

    public void waitFrame(WebElement element) {
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void switckToFramebyElement(WebElement element) {
        waitFrame(element);
    }

    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }

    public void switchtoFrame(WebElement element){

        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(element).perform();
    }
}
