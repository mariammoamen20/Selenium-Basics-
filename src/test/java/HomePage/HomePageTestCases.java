package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTestCases {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver =new ChromeDriver();
        driver.get("https://automationexercise.com/");
    }
    @Test
    public void verify_price() throws InterruptedException {
        WebElement actualPrice = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Thread.sleep(5000);
       String expectedPrice = "Rs. 500";
        //System.out.println(actualPrice.getText());
        Assert.assertEquals(actualPrice.getText(),expectedPrice);
    }
    @Test
    public void verify_product_name() throws InterruptedException {
        WebElement actualName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Thread.sleep(5000);
        String expectedName = "Blue Top";
        Assert.assertEquals(actualName.getText(),expectedName);
    }
   @Test
   public void add_item_to_cart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-product-id='1']")).click();
         Thread.sleep(5000);
       driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
       Thread.sleep(1000);

   }
   @Test
   public void view_item_product(){
       //Xpath indexing
       driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
   }
    @AfterMethod
    public void quite(){
        driver.quit();
    }
}
