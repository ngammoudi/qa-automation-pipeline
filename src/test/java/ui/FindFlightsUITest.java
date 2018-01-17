package ui;

import java.net.URL;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.WithTag;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class FindFlightsUITest {

    private static Wait<WebDriver> wait;
    private static DesiredCapabilities capabillities;
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        capabillities = DesiredCapabilities.chrome();
        /** URL is the selenium hub URL here **/
        driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), capabillities);
        capabillities.setBrowserName("chrome");
        wait = new WebDriverWait(driver, 6000);
    }
    @Test
    @WithTag(type="type", name="UI")
    /**
     * To test the UI
     * @throws Exception
     */
    public void testUI() throws Exception {
        /** Your application URL which you want to test **/
        driver.get("http://localhost:8090/myapp/index.html");
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {

                return webDriver.findElement(By.tagName("title")) != null;
            }
        });

        assertEquals("URL must be http://localhost:8090/myapp/index.html", "http://localhost:8090/myapp/index.html", driver.getCurrentUrl());
        /** put other asserts as well **/
    }
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
