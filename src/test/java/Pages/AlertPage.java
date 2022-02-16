package Pages;

import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;


    public AlertPage (WebDriver driver){
        this.driver=driver;
        elementMethods= new ElementMethods(driver);
        alertMethods=new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".nav-tabs>li>a")
    public List<WebElement> alertOptionsElement;
    @FindBy (css = "#OKTab>button")
    public WebElement okElement;
    @FindBy (css = "#CancelTab>button")
    public WebElement cancelElement;
    @FindBy (css = "#Textbox>button")
    public WebElement textboxElement;


    public void okFirstAlert(){
        elementMethods.clickElement(alertOptionsElement.get(0));
        elementMethods.clickElement(okElement);
        alertMethods.acceptAlert();
    }

    public void cancelSecondAlert(){
        elementMethods.clickElement(alertOptionsElement.get(1));
        elementMethods.clickElement(cancelElement);
        alertMethods.cancelAlert();
    }

    public void textboxAlert(String message){
        elementMethods.clickElement(alertOptionsElement.get(2));
        elementMethods.clickElement(textboxElement);
        alertMethods.acceptFillALert(message);
    }

    public void AlertsProcess(String message){
        okFirstAlert();
        cancelSecondAlert();
        textboxAlert(message);
    }
}
