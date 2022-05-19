import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.get("https://www.testfasttrackit.info/selenium-test");
    }

    @Test
    public void registrationWithValidCredentials() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jack");
        driver.findElement(By.id("lastname")).sendKeys("Sparrow");
        driver.findElement(By.id("email_address")).sendKeys("jacksparrow@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

//        WebElement dashboardTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
//        if (dashboardTextElement.isDisplayed()){
//            System.out.println("User successfully registered");
//        }else {
//            System.out.println("Please review carefully the user registration required fields!");
//        }

        WebElement thereIsAlreadyAnAccount = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li > span"));
        if (thereIsAlreadyAnAccount.isDisplayed()) {
            System.out.println("This email is already being used by another user!");
        }
    }

    @After
    public void close() {
        driver.close();
    }
}
