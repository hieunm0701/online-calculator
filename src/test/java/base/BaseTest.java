package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().version("93").setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
    }

    @After
    public void teardown() {
         if (driver != null)
            driver.quit();
    }


}
