package Help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        waitElement(element);
        element.click();
    }

    public void waitElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value){
        waitElement(element);
        element.sendKeys(value);
    }

    public void moveToElement(WebElement element){
        waitElement(element);
        Actions Action = new Actions(driver);
        //instructiune, executie
        Action.moveToElement(element).perform();
    }

    public void validationElementText(WebElement element, String value){
        waitElement(element);
        String actualmsg=element.getText();
        Assert.assertEquals("textul cautat nu e corect",value,actualmsg);
    }

    public void selectElementByText( WebElement element, String value){
        Select MonthElement = new Select(element);
        MonthElement.selectByVisibleText(value);
    }

    public void selectElementByValue(WebElement element,String value){
        Select MonthElement = new Select(element);
        MonthElement.selectByValue(value);
    }
}
