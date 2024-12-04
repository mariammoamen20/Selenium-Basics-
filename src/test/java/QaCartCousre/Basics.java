package QaCartCousre;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Objects;

public class Basics {
    WebDriver driver;

    @Test
    public void basics() {
        driver = new ChromeDriver();
        //Open Html using selenium in chrome => locate the file in project and use "file://absolute path"
        driver.get("file:///home/mariam/Work/Learning/Testing/Automation_Rania_Mokhtar/Java/shopping_website/src/test/java/QaCartCousre/index.html");

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

    }

}
