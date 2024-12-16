package QaCartCousre;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Basics {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //Open Html using selenium in chrome => locate the file in project and use "file://absolute path"
        driver.get("file:///home/mariam/Work/Learning/Testing/Automation_Rania_Mokhtar/Java/shopping_website/src/test/java/QaCartCousre/index.html");
        driver.manage().window().maximize();
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void basics() {

        //Get element by class name
        String className = driver.findElement(By.className("list1")).getText();
        System.out.println(className);

        //When i use tag name it will get the first tag because there will be a lot of element with same tag name
        String tag = driver.findElement(By.tagName("li")).getText();
        System.out.println(tag);

        //To get element when its tag is <a and contain link >
        String text = driver.findElement(By.linkText("Go to About Page")).getText();
        System.out.println(text);

        //Dimension class makes control of resizing screens and it takes (width and height) of the size we want
        Dimension iphoneSE = new Dimension(375, 667);
        driver.manage().window().setSize(iphoneSE);

        //Get current url of website
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //Get title in browser tab
        String title = driver.getTitle();
        System.out.println("The Title is " + title);

        //Get page source
        String pageSource = driver.getPageSource();
        System.out.println("The page source is " + pageSource);

        //The same exactly as get("")
        driver.navigate().to("https://www.youtube.com/watch?v=qJQnFeXiKxI&list=PLJ2FoWouEU2w8wnsblKVolmhujkOWgkjo&index=19");

        //Navigate back
        driver.navigate().back();

        //Navigate forward
        driver.navigate().forward();

        //Refresh page
        driver.navigate().refresh();

        //testate id attribute
        //  driver.findElement(By.xpath("//*[data-testid ='about-page']")).getText();

        //Css Selector (#ID)


    }

    //Css Selector by id (#ID)
    @Test
    public void cssSelectorById() throws InterruptedException {
        String cssSelector = driver.findElement(By.cssSelector("#welcome")).getText();
        System.out.println("Css Selector " + cssSelector);
    }

    //Css Selector by class (.class)
    @Test
    public void cssSelectorByClass() throws InterruptedException {
        String cssSelector = driver.findElement(By.cssSelector(".list1")).getText();
        System.out.println("Css Selector " + cssSelector);
    }

    //Css Selector by path ("attribute = value")
    @Test
    public void cssSelectorByPath() throws InterruptedException {
        String cssSelector = driver.findElement(By.cssSelector("[name=\"description\"]")).getText();
        //String cssSelector = driver.findElement(By.cssSelector("[name="description"]")).getText();
        System.out.println("Css Selector " + cssSelector);
    }

    //Css selector using parent and child
    @Test
    public void cssSelectorByChildAndParent() {
        String cssSelector = driver.findElement(By.cssSelector(".course-list .list1")).getText();
        System.out.println("Css Selector " + cssSelector);
    }

    //We can use symbol (>) if we deal with direct class and children
    @Test
    public void cssSelectorByDirectParent() {
        String cssSelector = driver.findElement(By.cssSelector(".course-list >.list1")).getText();
        System.out.println("Css Selector " + cssSelector);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
    //$(".course-list li:nth-of-type(9)") => when i want to check a specific element in list element

    //Using dynamic value instead of static or hard coded value
    @Test
    public void byClass() {
        By banana = By.id("Banana");
        WebElement bananaElement = driver.findElement(banana);
        String webElement = bananaElement.getText();
        System.out.println("WebElement " + webElement);

    }

    //Here I told it to get items in list with tag (li) beneath this class course-list
    @Test
    public void getElements() {
        String elementById = driver.findElements(By.cssSelector(".course-list li")).get(1).getText();
        System.out.println("Element By ID " + elementById);
    }

    @Test
    public void checkBox2() {
        WebElement id = driver.findElement(By.name("Banana"));
        id.click();
    }

    //Automate checkbox
    @Test
    public void checkBox() {
        driver.get("https://www.defacto.com/ar-eg/30-40-50-eg?filter=gender:woman");
        driver.findElement(By.cssSelector("[data-value=أولادي]")).click();
    }

    //Automate dropdown list
    @Test
    public void dropdown() throws InterruptedException {
        By id = By.id("courses");
        WebElement courses = driver.findElement(id);
        //Select class take an object from web element
        Select select = new Select(courses);
        //  select.selectByIndex(2);
        //  select.selectByValue("selenium");
        select.selectByVisibleText("Selenium");
        Thread.sleep(3000);
    }

    @Test
    public void isDisplayed() throws InterruptedException {
        By id = By.id("courses");
        //Is displayed return true if the element exist
        //Is displayed return false if the code of this element in the code but not visible
        boolean courses = driver.findElement(id).isDisplayed();
        System.out.println(courses);
    }

    @Test
    public void isEnabled() {
        By id = By.id("courses");
        //Is enabled return true if the element enable and can do action on it
        //Is enabled return false when the element isn't enabled and can't do action on it like (unclickable button or disabled field)
        boolean courses = driver.findElement(id).isEnabled();
        System.out.println(courses);
    }

    @Test
    public void isSelected() {
        By id = By.id("Banana");
        //Is selected return true if the element is selected
        // return false when the element isn't selected
        WebElement checkbox = driver.findElement(id);
        checkbox.click();
        boolean isSelected = driver.findElement(id).isSelected();
        System.out.println(isSelected);
    }

    @Test
    public void getAttribute() {
        By id = By.id("Banana");
        //This lines me get value of attribute named (id)
        String attribute = driver.findElement(id).getAttribute("id");
        System.out.println(attribute);
    }

    @Test
    public void getTagName() {
        By id = By.id("Banana");
        //This lines me get tag name of this element
        String tagName = driver.findElement(id).getTagName();
        System.out.println(tagName);
    }

    @Test
    public void getCssValue() {
        By id = By.id("Banana");
        //This lines me get value of attribute named (id)
        String cssValue = driver.findElement(id).getCssValue("font-weight");
        System.out.println(cssValue);
    }

    @Test
    public void getLocation() {
        By id = By.id("Banana");
        Point location = driver.findElement(id).getLocation();
        System.out.println(location);
        System.out.println(location.x);
        System.out.println(location.y);
    }

    @Test
    public void getSize() {
        By id = By.id("Banana");
        //get size of this check box
        Dimension size = driver.findElement(id).getSize();
        System.out.println(size);
        System.out.println(size.width);
        System.out.println(size.height);
    }

    //Get Rect method
    @Test
    public void getRect() {
        By id = By.id("Banana");
        Rectangle rectangle = driver.findElement(id).getRect();
        System.out.println(rectangle);
        System.out.println(rectangle.width);
        System.out.println(rectangle.height);
        System.out.println(rectangle.x);
        System.out.println(rectangle.y);
    }

    //Get AccessibleName in aria label or aria description in css
    @Test
    public void getAcc() {
        By inputEmail = By.id("inputEmail");
        String accessibleName = driver.findElement(inputEmail).getAccessibleName();
        System.out.println(accessibleName);
    }

    //To perform double click we do this by using actions class
    @Test
    public void doubleClick() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement double_click = driver.findElement(By.id("right-click"));
        action.doubleClick(double_click).perform();
        Thread.sleep(2000);
    }

    //To perform right click we do this by using actions class
    @Test
    public void rightClick() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement double_click = driver.findElement(By.id("right-click"));
        action.contextClick(double_click).perform();
        Thread.sleep(2000);
    }
    //Mo
    @Test
    public void moveElement() throws InterruptedException {
       // WebElement trigger = driver.findElement(By.cssSelector(".trigger"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement trigger = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".trigger")));
        Actions action = new Actions(driver);
        action.moveToElement(trigger).perform();
    }
}





