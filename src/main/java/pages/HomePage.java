package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class HomePage extends PageObject {
    @FindBy(xpath= "//input[contains(@value,'Find Flights')]")
    public WebElement findFlightsButton;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        open();
    }

    public void findFlights(){
        findFlightsButton.click();
    }
}