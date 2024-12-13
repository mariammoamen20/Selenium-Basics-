package AutomatedExrcies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDetailsPage {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/product_details/1");
        driver.manage().window().maximize();
        //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void increaseButton() throws InterruptedException {
        By quantityId = By.id("product_id");
        WebElement quantityIdClick = driver.findElement(quantityId);
        if (quantityIdClick.isDisplayed()) {
            System.out.println("Element" + quantityIdClick.getRect());
            quantityIdClick.click();
        }
        Thread.sleep(5000);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
