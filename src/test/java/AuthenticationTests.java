import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationTests {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        // Configura automaticamente o ChromeDriver com a versão certa
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void testLoginEmptyFields() {
        // Scenario 1: Trying to login with empty fields
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();

        // Verify if error is displayed
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorMessage.isDisplayed(), "Login error not displayed.");
    }

    @Test
    public void testInvalidEmail() {
        // Scenario 2: Create account with invalid email
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField.sendKeys("user@invalid");

        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        // Espera o erro com id específico
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error"))
        );

        assertTrue(errorMessage.isDisplayed(), "Invalid email error message is not displayed.");
    }

    @Test
    public void testNonExistingEmail() {

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("noneexistentuser@example.com");

        WebElement passWordField = driver.findElement(By.id("passwd"));
        passWordField.sendKeys("validpassword");

        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
        assertTrue(errorMessage.isDisplayed(), "Non-existent error message is not displayed.");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}