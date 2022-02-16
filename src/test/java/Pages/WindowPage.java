package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(driver);
        pageMethods=new PageMethods(driver);
        windowMethods= new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".nav-tabs>li>a")
    public List<WebElement> windowsOptions;
    @FindBy (css = "#Tabbed>a>button")
    public WebElement clickBtn1;
    @FindBy (css = "button[class='btn btn-primary']")
    public WebElement clickBtn2;
    @FindBy (css = "button[onclick='multiwindow()']")
    public WebElement clickBtn3;


    public void oneNewTab(){
        elementMethods.clickElement(windowsOptions.get(0));
        elementMethods.clickElement(clickBtn1);
        windowMethods.switchTOTab(1);
        driver.close();
        windowMethods.switchTOTab(0);
    }

    public void oneNewWindow(){
        elementMethods.clickElement(windowsOptions.get(1));
        elementMethods.clickElement(clickBtn2);
        windowMethods.switchTOTab(1);
        driver.close();
        windowMethods.switchTOTab(0);
    }

    public void openTwoWindows(){
        elementMethods.clickElement(windowsOptions.get(2));
        elementMethods.clickElement(clickBtn3);
        windowMethods.switchTOTab(2);
        driver.close();
        windowMethods.switchTOTab(1);
        driver.close();
        windowMethods.switchTOTab(0);
    }

    public void wholeTabWindowProcess(){
        oneNewTab();
        oneNewWindow();
        openTwoWindows();
    }

}
