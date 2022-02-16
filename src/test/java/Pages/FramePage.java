package Pages;

import Help.ElementMethods;
import Help.FrameMethods;
import org.junit.experimental.theories.FromDataPoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementMethods= new ElementMethods(driver);
        frameMethods= new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "singleframe")
    public WebElement singleFrame;
    @FindBy (css = "input[type='text']")
    public WebElement inputFrame;
    @FindBy (css = "li>a[href='#Multiple']")
    public WebElement clickMultipleFrames;
    @FindBy (css = "iframe[src='MultipleFrames.html']")
    public WebElement exteriorFrame;
    @FindBy (css = "iframe[src='SingleFrame.html']")
    public WebElement interiorFrame;
    @FindBy (css = "input[type='text']")
    public WebElement inputInteriorFrame;

    public void switchToSingleFrame(String value){
        frameMethods.switckToFramebyElement(singleFrame);
        elementMethods.fillElement(inputFrame, value);
        frameMethods.switchToDefault();
    }

    public void switchToMultipleFrames(String value){
        elementMethods.clickElement(clickMultipleFrames);
        frameMethods.switckToFramebyElement(exteriorFrame);
        frameMethods.switckToFramebyElement(interiorFrame);
        elementMethods.fillElement(inputInteriorFrame, value);
    }

    public void framesProcess(String mesaj1, String mesaj2){
        switchToSingleFrame(mesaj1);
        switchToMultipleFrames(mesaj2);
    }
}
