package AutomatedExrcies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

public class HomePageTestCases {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Adjust implicit wait
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test
    public void verify_price() throws InterruptedException {
        WebElement actualPrice = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Thread.sleep(5000);
        String expectedPrice = "Rs. 500";
        //System.out.println(actualPrice.getText());
        Assert.assertEquals(actualPrice.getText(), expectedPrice);
    }

    @Test
    public void verify_product_name() throws InterruptedException {
        WebElement actualName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Thread.sleep(5000);
        String expectedName = "Blue Top";
        Assert.assertEquals(actualName.getText(), expectedName);
    }

    @Test
    public void add_item_to_cart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-product-id='1']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(1000);

    }

    @Test
    public void view_item_product() {
        //Xpath indexing
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
    }

    @Test
    public void check_certain_items() {
        String[] productId = {"Rs. 1000", "Rs. 315", "Rs. 679", "Rs. 478"};
        for (int i = 0; i < productId.length; i++) {
            driver.findElement(By.xpath("(//*[text()='View Product'])[" + (i + 1) + "]")).click();
            driver.navigate().back();
        }
    }

    //A method that loops on all product to check if they opened or not
    @Test
    public void check_all_product() {
        //I store a list of all item with this xpath
        List<WebElement> products = driver.findElements(By.xpath(("//*[text()='View Product']")));
        for (int i = 1; i < products.size(); i++) {
            try {
                //get index for every item from the list and click on it
                products.get(i).click();
                driver.navigate().back();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }

    @Test
    public void scrollingRight() {
        try {
            WebElement rightButton = driver.findElement(By.xpath("//*[@class='right recommended-item-control']"));
            for (int i = 0; i < 5; i++) {
                rightButton.click();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //
    @Test
    public void scrollingLeft() {
        try {
            WebElement rightLeft = driver.findElement(By.xpath("//*[@class='left recommended-item-control']"));
            for (int i = 0; i < 5; i++) {
                rightLeft.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void check_empty_email(){
        driver.findElement(By.id("subscribe")).click();
    }
    @AfterMethod
    public void quite() {
        driver.quit();
    }
}
