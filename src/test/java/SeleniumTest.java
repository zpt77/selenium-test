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

        Faker faker = new Faker();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customer\\.firstName")));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = driver.findElement(By.cssSelector("#customer\\.lastName"));
        lastName.sendKeys(faker.name().lastName());
        WebElement address = driver.findElement(By.cssSelector("#customer\\.address\\.street"));
        address.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.cssSelector("#customer\\.address\\.city"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.cssSelector("#customer\\.address\\.state"));
        state.sendKeys(faker.address().state());
        WebElement zipCode = driver.findElement(By.cssSelector("#customer\\.address\\.zipCode"));
        zipCode.sendKeys(faker.address().zipCode());
        WebElement phone = driver.findElement(By.cssSelector("#customer\\.phoneNumber"));
        phone.sendKeys(faker.phoneNumber().phoneNumber());
        WebElement ssn = driver.findElement(By.cssSelector("#customer\\.ssn"));
        ssn.sendKeys(faker.number().digits(9));

        WebElement username = driver.findElement(By.cssSelector("#customer\\.username"));
        String usernameValue = faker.name().username();
        username.sendKeys(usernameValue);

        WebElement password = driver.findElement(By.cssSelector("#customer\\.password"));
        String passwordValue = faker.leagueOfLegends().champion();
        password.sendKeys(passwordValue);

        WebElement confirm = driver.findElement(By.cssSelector("#repeatedPassword"));
        confirm.sendKeys(passwordValue);

        WebElement submit = driver.findElement(By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input"));
        submit.click();
    }

}

