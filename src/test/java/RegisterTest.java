import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.get("https://www.testfasttrackit.info/selenium-test");
    }

    @Test
    public void registrationWithValidCredentials() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title=Register]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jack");
        driver.findElement(By.id("lastname")).sendKeys("Sparrow");
        driver.findElement(By.id("email_address")).sendKeys("jacksparrow@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set span")).click();

//        WebElement successfulRegister = driver.findElement(By.cssSelector(".success-msg span"));
//        Assert.assertTrue(successfulRegister.isDisplayed());
    }

    @Test
    public void registerWithAlreadyRegisteredEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title=Register]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jack");
        driver.findElement(By.id("lastname")).sendKeys("Sparrow");
        driver.findElement(By.id("email_address")).sendKeys("jacksparrow@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set span")).click();

        WebElement emailAlreadyRegistered = driver.findElement(By.cssSelector(".error-msg span"));
        Assert.assertTrue(emailAlreadyRegistered.isDisplayed());
    }


    @After
    public void close() {
        driver.close();
    }
}
