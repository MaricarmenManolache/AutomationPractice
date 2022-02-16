package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver) {

        this.driver = driver;
    }
    //asteapta sa se incarce pt navigate url
    public void navigateToURL (String value){
        driver.navigate().to(value);
        waitExplicittoLoadURL(value);
    }

    public void waitExplicittoLoadURL (String value){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(value));
    }
}
