import jdk.swing.interop.SwingInterOpUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {
    private WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.get("https://www.testfasttrackit.info/selenium-test");
    }

    @Test
    public void addItemToWishlistWithoutAccount() {
        driver.findElement(By.cssSelector(".nav-5.parent a")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector(".swatch-label")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();

        WebElement youNeedAnAccountToAddToWishlist = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertTrue(youNeedAnAccountToAddToWishlist.isDisplayed());
    }

    @After
    public void close() {
//        driver.close();
    }

}
