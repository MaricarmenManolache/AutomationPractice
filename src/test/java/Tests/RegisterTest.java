package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class RegisterTest extends SharedData {
    //daca avem mai multe elemente cu acelasi nume, le diferentiem prin parinte "form>"
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    @Test
    public void RegisterTest() {
        elementMethods= new ElementMethods(driver);
        pageMethods= new PageMethods(driver);

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(SkipsignIn);

        WebElement FirstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        elementMethods.fillElement(FirstName,"Maricarmen");

        WebElement LastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        elementMethods.fillElement(LastName,"Manolache");

        WebElement Adress = driver.findElement(By.cssSelector("[ng-model='Adress']"));
        elementMethods.fillElement(Adress,"Floresti");

        WebElement EmailAdressElement = driver.findElement(By.cssSelector("[ng-model='EmailAdress']"));
        elementMethods.fillElement(EmailAdressElement,"manoalche.maricarmen7@gmail.com");

        WebElement PhoneElement = driver.findElement(By.cssSelector("[ng-model='Phone']"));
        elementMethods.fillElement(PhoneElement,"0753603027");

        WebElement Hobbies1 = driver.findElement(By.id("checkbox1"));
        elementMethods.clickElement(Hobbies1);

        WebElement Hobbies2 = driver.findElement(By.id("checkbox3"));
        elementMethods.clickElement(Hobbies2);

        WebElement skills = driver.findElement(By.id("Skills"));
        elementMethods.selectElementByText(skills,"Java");

        WebElement Password = driver.findElement(By.id("secondpassword"));
        elementMethods.fillElement(Password,"Maricarmen12");

        WebElement CPassword = driver.findElement(By.id("firstpassword"));
        elementMethods.fillElement(CPassword,"Maricarmen12");

        WebElement YearElement = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[1]/select"));
        elementMethods.selectElementByValue(YearElement, "1998");
        WebElement MonthElement= driver.findElement(By.cssSelector("[ng-model='monthbox']"));
        elementMethods.selectElementByValue((WebElement) MonthElement,"July");

        WebElement DayElement = driver.findElement(By.id("daybox"));
        elementMethods.selectElementbyIndex(DayElement, 7);

        WebElement Gender = driver.findElement(By.cssSelector("[value='FeMale']"));
        elementMethods.clickElement(Gender);

        WebElement LanguageDropdownElement = driver.findElement(By.id("msdd"));
        elementMethods.clickElement(LanguageDropdownElement);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");



        //declaram lista de elemente
        List <WebElement> LanguageOptionsElement = driver.findElements(By.cssSelector("ul.ui-autocomplete.ui-front>li>a"));
        for (int index=0; index < LanguageOptionsElement.size(); index++) {
            if (LanguageOptionsElement.get(index).getText().equals("Urdu")
                    || (LanguageOptionsElement.get(index).getText().equals("English")
                    ||(LanguageOptionsElement.get(index).getText().equals("Arabic"))))
            {
                LanguageOptionsElement.get(index).click();
            }
        }


        // il inchidem
        elementMethods.clickElement(PhoneElement);
        WebElement SelectCountry = driver.findElement(By.cssSelector("span[role='combobox']"));
        elementMethods.clickElement(SelectCountry);
        WebElement InputCountry = driver.findElement(By.className("select2-search__field"));
        elementMethods.fillElement(InputCountry, "Bangladesh");
        InputCountry.sendKeys(Keys.ENTER);

        WebElement SubmitElement = driver.findElement(By.id("submitbtn"));
        elementMethods.clickElement(SubmitElement);

        WebElement Image = driver.findElement(By.id("imagesrc"));
        elementMethods.Image(Image, "D:\\random\\65265296_2436148643130665_8232381803013341184_n.jpg");
        driver.close();








    }
}