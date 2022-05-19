import jdk.swing.interop.SwingInterOpUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {
    WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.get("https://www.testfasttrackit.info/selenium-test");
    }

    @Test
    public void addItemToWishlist() {
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();

        WebElement dashboardTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > div > h1"));
        if (dashboardTextElement.isDisplayed()) {
            System.out.println("User needs to create an account first!");
        } else {
            System.out.println("Item was succesfully added to wishlist!");
        }

//         String textfromElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > div > h1")).getText();
//         if (textfromElement.equals("LOGIN OR CREATE AN ACCOUNT")){
//             System.out.println("User needs to register first!");
//         } else {
//             System.out.println("Item succesfully added to wishlist!");
//         }
    }

    @After
    public void close() {
        driver.close();
    }

}
