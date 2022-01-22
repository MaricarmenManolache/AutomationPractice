package Tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class RegisterTest {
    public WebDriver driver;

    //daca avem mai multe elemente cu acelasi nume, le diferentiem prin parinte "form>"

    @Test
    public void RegisterTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        WebElement SkipsignIn = driver.findElement(By.id("btn2"));
        SkipsignIn.click();

        WebElement FirstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        FirstName.sendKeys("Maricarmen");

        WebElement LastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        LastName.sendKeys("Manolache");

        WebElement Adress = driver.findElement(By.cssSelector("[ng-model='Adress']"));
        Adress.sendKeys("Floresti");

        WebElement EmailAdressElement = driver.findElement(By.cssSelector("[ng-model='EmailAdress']"));
        EmailAdressElement.sendKeys("manoalche.maricarmen7@gmail.com");

        WebElement PhoneElement = driver.findElement(By.cssSelector("[ng-model='Phone']"));
        PhoneElement.sendKeys("0753603027");

        WebElement Hobbies1 = driver.findElement(By.id("checkbox1"));
        Hobbies1.click();

        WebElement Hobbies2 = driver.findElement(By.id("checkbox3"));
        Hobbies2.click();

        Select Dropdown = new Select(driver.findElement(By.id("Skills")));
        Dropdown.selectByIndex(7);

        WebElement Password = driver.findElement(By.id("secondpassword"));
        Password.sendKeys("Maricarmen");

        WebElement CPassword = driver.findElement(By.id("firstpassword"));
        CPassword.sendKeys("Maricarmen");

        Select YearElement = new Select((driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[1]/select"))));
        YearElement.selectByValue("1998");

        Select MonthElement = new Select(driver.findElement(By.cssSelector("[ng-model='monthbox']")));
        MonthElement.selectByValue("July");

        Select DayElement = new Select(driver.findElement(By.id("daybox")));
        DayElement.selectByIndex(7);

        WebElement Gender = driver.findElement(By.cssSelector("[value='FeMale']"));
        Gender.click();

        WebElement LanguageDropdownElement = driver.findElement(By.id("msdd"));
        LanguageDropdownElement.click();

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
        PhoneElement.click();
        WebElement SelectCountry = driver.findElement(By.cssSelector("span[role='combobox']"));
        SelectCountry.click();
        WebElement InputCountry = driver.findElement(By.className("select2-search__field"));
        InputCountry.sendKeys("Bangladesh");
        InputCountry.sendKeys(Keys.ENTER);

        WebElement SubmitElement = driver.findElement(By.id("submitbtn"));
        SubmitElement.click();

    WebElement Image = driver.findElement(By.id("imagesrc"));
    Image.sendKeys("D:\\random\\65265296_2436148643130665_8232381803013341184_n.jpg");

    driver.close();








    }
}