package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    public RegisterPage(WebDriver driver){
        this.driver= driver;
        elementMethods= new ElementMethods(driver);
        pageMethods=new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='SwitchTo']")
    public WebElement switchToElement;
    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement alertsElement;
    @FindBy(xpath = "//a[text()='Windows']")
    public WebElement windowsElement;
    @FindBy (xpath = "//a[text()='Frames']")
    public WebElement framesElement;
    @FindBy (css = "input[placeholder='First Name']")
    public WebElement firstNameElement;
    @FindBy (css = "input[placeholder='Last Name']")
    public WebElement lastNameElement;
    @FindBy (css = "[ng-model='Adress']")
    public  WebElement adressElement;
    @FindBy (css = "[ng-model='EmailAdress']")
    public WebElement emailElement;
    @FindBy (css = "[ng-model='Phone']")
    public WebElement phoneElemenr;
    @FindBy (id = "checkbox1")
    public WebElement hobbies1;
    @FindBy (id = "checkbox2")
    public WebElement hobbies2;
    @FindBy(id = "Skills")
    public WebElement skillsElement;
    @FindBy (id = "secondpassword")
    public WebElement passwordElement;
    @FindBy (id =  "firstpassword")
    public WebElement confirmPassElement;
    @FindBy (xpath = "/html/body/section/div/div/div[2]/form/div[11]/div[1]/select")
    public WebElement yearElement;
    @FindBy (css =  "[ng-model='monthbox']")
    public WebElement monthElement;
    @FindBy (id = "daybox")
    public WebElement dayElement;
    @FindBy (css = "[value='FeMale']")
    public WebElement femaleGenderElement;
    @FindBy (id = "msdd")
    public WebElement languagesElement;
    @FindBy(css = ".ui-autocomplete.ui-front>li>a")
    public List<WebElement> languagesOptionsElement;
    @FindBy (id = "imagesrc")
    public WebElement uploadFileElement;
    @FindBy(css = "span[role='combobox']")
    public WebElement countryElement;
    @FindBy(className = "select2-search__field")
    public WebElement countryInputElement;

    //metode

    public void goToFramesPage(){
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(framesElement);
        pageMethods.navigateToURL("http://demo.automationtesting.in/Frames.html");
    }

    public void goToAlertPage(){
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(alertsElement);
        pageMethods.navigateToURL("http://demo.automationtesting.in/Alerts.html");
    }

    public void goToWindowPage() {
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(windowsElement);
        pageMethods.navigateToURL("http://demo.automationtesting.in/Windows.html");
    }



    public void fillFirstName(String value){
        elementMethods.fillElement(firstNameElement, value);
    }

    public void fillLastName(String value){
        elementMethods.fillElement(lastNameElement, value);
    }

    public void fillAdress(String value){
        elementMethods.fillElement(adressElement, value);
    }

    public void fillEmail(String value){
        elementMethods.fillElement(emailElement, value);
    }

    public void fillPhone(String value){
        elementMethods.fillElement(phoneElemenr,value);
    }

    public void clickGender(){
        elementMethods.clickElement(femaleGenderElement);
    }

    public void clickHobby(){
        elementMethods.clickElement(hobbies1);
        elementMethods.clickElement(hobbies2);
    }

    public void chooseLanguages(String value){
        elementMethods.clickElement(languagesElement);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        for (int index=0; index< languagesOptionsElement.size(); index++){
            if (languagesOptionsElement.get(index).getText().equals(value)){
                languagesOptionsElement.get(index).click();
            }
        }
    }

    public void chooseLanguages(List<String> values){
        elementMethods.clickElement(languagesElement);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        for (int index=0; index<languagesOptionsElement.size();index++){
            if (values.contains(languagesOptionsElement.get(index).getText())){
                languagesOptionsElement.get(index).click();
            }
        }
    }
    public void selectSkill(String value){
        elementMethods.selectElementByText(skillsElement,value);
    }

    public void chooseCountry(String value){
        elementMethods.clickElement(countryElement);
        elementMethods.fillElement(countryInputElement,value);
        countryInputElement.sendKeys(Keys.ENTER);
    }

    public void selectYear(String value){
        elementMethods.selectElementByValue(yearElement, value);
    }

    public void selectMonth(String value){
        elementMethods.selectElementByValue(monthElement, value);
    }
    public void selectDay(String value){
        elementMethods.selectElementByValue(dayElement, value);
    }

    public void uploadFile(String value){
        elementMethods.fillElement(uploadFileElement, value);
    }

    public void fillPasword(String value){
        elementMethods.fillElement(passwordElement, value);
    }

    public void fillConfirmPassword(String value){
        elementMethods.fillElement(confirmPassElement, value);
    }


    public void registerValidProcess(String firstName, String lastName, String adress, String email,String phone,
                                     String language, String skill, String country, String year, String month,String day,String file,
                                     String password, String confirmPassword){

        fillFirstName(firstName);
        fillLastName(lastName);
        fillAdress(adress);
        fillEmail(email);
        fillPhone(phone);
        chooseLanguages(language);
        clickGender();
        clickHobby();
        selectSkill(skill);
        chooseCountry(country);
        selectYear(year);
        selectMonth(month);
        selectDay(day);
        uploadFile(file);
        fillPasword(password);
        fillConfirmPassword(confirmPassword);
    }

}
