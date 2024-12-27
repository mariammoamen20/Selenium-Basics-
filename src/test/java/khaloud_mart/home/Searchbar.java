package khaloud_mart.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.channels.Selector;
import java.time.Duration;

public class Searchbar {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://khlodmart.sahl.store/ar");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    //I faced here an exception called "ElementClickInterceptedException"
    // it happens when you are trying to interact with this element but selenium can't find it
    //because of some reasons like an element blocked the element you want to interact with making the target element unclickable at the moment
    // A loader or modal overlay (like a spinner or loading screen) is displayed while the page is loading or processing an action.
    //Or Time issue where the page isn't fully loaded or an element isn't yet in a clickable state.
    @Test
    public void check_empty_search() throws InterruptedException {
        // I fix it by explicit
        // wait till loader disappears then find the element and click
        // if it doesn't work increase time or duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a maximum of 10 seconds
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-wrapper.hidden")));

        By xPath = By.xpath("(//*[@class='input-group-text'])[2]");
        driver.findElement(xPath).click();

    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"حذاء"},
                {"شنط"},
                {"ملابس"},

        };
    }

    //function that take explicit wait and find element function to make code more readable
    public void searchType(CharSequence charSequence) {
        // Wait for a maximum of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".search-type")));
        By cssSelector = By.cssSelector(".search-type");
        driver.findElement(cssSelector).sendKeys(charSequence);

    }

    //Function perform clicking on item
    public void click() {
        By xPath = By.xpath("(//*[@class='input-group-text'])[2]");
        driver.findElement(xPath).click();
    }

    @Test
    public void check_valid_search_data() throws InterruptedException {
        searchType("حذاء");
        click();
    }


    @Test
    public void check_invalid_input_with_no_result() throws InterruptedException {
        searchType("Nail Polish");
        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_with_spaces() throws InterruptedException {
        searchType(" ");
        click();
        Thread.sleep(20000);
    }

    @Test
    public void check_invalid_input_start_with_space() throws InterruptedException {
        searchType(" حذاء ");
        click();
        Thread.sleep(20000);
    }

    @Test
    public void check_invalid_input_using_special_characters() throws InterruptedException {
        searchType("@حذاء#");
        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_using_mix_numbers_and_letters() throws InterruptedException {
        searchType("شنط123");
        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_using_only_letters() throws InterruptedException {
        searchType("123456");
        click();
        Thread.sleep(20000);

    }

    //This function implement depend on the number of data you provide here in these cases it implemented 3 times
    @Test(dataProvider = "searchData")
    public void check_invalid_input_exceed_the_limit_of_characters(String searchData) throws InterruptedException {
        //instead of this
        // searchType("شنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطشنطv");

        //I use this function (repeat) to let me repeat any number of characters as I like instead use hardcoding
        String largeInput = searchData.repeat(152);
        searchType(largeInput);

        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_using_mixed_characters_arabic_and_english() throws InterruptedException {
        searchType("حذاءMM");
        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_using_capital_letters_only() throws InterruptedException {
        searchType("SHOES");
        click();
        Thread.sleep(20000);

    }

    @Test
    public void check_invalid_input_making_first_letter_is_capital() throws InterruptedException {
        searchType("Shoes");
        click();
        Thread.sleep(20000);
    }

    public void select(String value) {
        WebElement list = driver.findElement(By.name("category_id[]"));
        Select select = new Select(list);
        select.selectByVisibleText(value);
    }
    @DataProvider(name = "dropdown")
    public Object[][] selector(){
        return new Object[][]{
                {"حلق"},
                {"حذاء"},
                {"شنط"},
        };
    }
    @Test(dataProvider = "dropdown")
    public void check_shoes_part_search(String text) {
        //Selector
        select("الأحذية");
        searchType(text);
        click();
    }
    @Test(dataProvider = "dropdown")
    public void check_accessories_part_with_search(String text) throws InterruptedException {
        //Selector
        select("اكسسوارات");
        searchType(text);
        click();
        Thread.sleep(2000);
    }
    @Test
    public void check_accessories_part() throws InterruptedException {
        //Selector
        select("اكسسوارات");
     //   searchType(text);
        click();
        Thread.sleep(2000);
    }
    @Test
    public void accountIcon() throws InterruptedException {
        driver.findElement(By.cssSelector(".feather-user")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='تسجيل الدخول']")).click();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
