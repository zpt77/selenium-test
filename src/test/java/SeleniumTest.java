import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.time.Duration;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.cssSelector("#L2AGLb > div"));
        element.click();
    }

    @Test
    public void openParabank() {
        driver.get("https://parabank.parasoft.com/");
    }

    @Test
    public void register() {
        WebElement element = driver.findElement(By.cssSelector("#loginPanel > p:nth-child(3) > a"));
        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customer\\.firstName")));

    }

}

