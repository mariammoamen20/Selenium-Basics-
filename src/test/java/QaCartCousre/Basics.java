package QaCartCousre;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class Basics {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //Open Html using selenium in chrome => locate the file in project and use "file://absolute path"
        driver.get("file:///home/mariam/Work/Learning/Testing/Automation_Rania_Mokhtar/Java/shopping_website/src/test/java/QaCartCousre/index.html");

    }

    @Test
    public void basics() {
        driver.manage().window().maximize();

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
}
