import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.get("https://www.testfasttrackit.info/selenium-test");
    }

    @Test
    public void loginWithValidCredentials() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("qwerty123@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("qwerty");
        driver.findElement(By.id("send2")).click();

        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertTrue(dashboardTextElement.isDisplayed());
    }

    @Test
    public void loginWithInvalidPassword() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("qwerty123@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("12345678");
        driver.findElement(By.id("send2")).click();

        String textFromElement = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }

    @Test
    public void loginWithInvalidEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("qwerty12345@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("qwerty");
        driver.findElement(By.id("send2")).click();

        String textFromElement = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }

    @Test
    public void loginWithoutCredentialsTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("send2")).click();

        WebElement dashboardTextElement = driver.findElement(By.id("advice-required-entry-email"));
        Assert.assertTrue(dashboardTextElement.isDisplayed());
    }

    @Test
    public void verifyForgotPasswordWithValidEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.cssSelector(".f-left")).click();
        driver.findElement(By.id("email_address")).sendKeys("qwerty12345@yahoo.com");
        driver.findElement(By.cssSelector("[title=Submit]")).click();

        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(dashboardTextElement.isDisplayed());
    }

    @Test
    public void verifyForgotPasswordWithInvalidEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.cssSelector(".f-left")).click();
        driver.findElement(By.id("email_address")).sendKeys("assafsafasf@yahoo.com");
        driver.findElement(By.cssSelector("[title=Submit]")).click();

        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(dashboardTextElement.isDisplayed());
    }

    @Test
    public void verifyForgotPasswordWithoutText() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title^=Log]")).click();
        driver.findElement(By.cssSelector(".f-left")).click();
        driver.findElement(By.cssSelector("[title=Submit]")).click();

       WebElement dashboardTextElement = driver.findElement(By.cssSelector(".validation-advice"));
       Assert.assertTrue(dashboardTextElement.isDisplayed());
    }


    @After
    public void close() {
        driver.close();
    }

}
