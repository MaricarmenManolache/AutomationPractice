package Help;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
    public WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchTOTab (Integer index){

        List<String> Windows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Windows.get(index));
        System.out.println("Titlul paginii: "+driver.getTitle());
    }
    public void closeCurrentTab(){
        driver.close();
    }
}
