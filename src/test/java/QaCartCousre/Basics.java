package QaCartCousre;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Basics {
    WebDriver driver;
    @Test
    public void basics() {
        driver = new ChromeDriver();
        //Open Html using selenium in chrome => locate the file in project and use "file://absolute path"
        driver.get("file:///home/mariam/Work/Learning/Testing/Automation_Rania_Mokhtar/Java/shopping_website/src/test/java/QaCartCousre/index.html");

        driver.manage().window().maximize();
        //Dimension class makes control of resizing screens and it takes (width and height) of the size we want
        Dimension iphoneSE = new Dimension(375,667);
        driver.manage().window().setSize(iphoneSE);

        //Get current url of website
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //Get title in browser tab
        String title = driver.getTitle();
        System.out.println("The Title is " + title);

        //Get page source
        String pageSource = driver.getPageSource();
        System.out.println("The page source is " + pageSource );

        //The same exactly as get("")
        driver.navigate().to("https://www.youtube.com/watch?v=qJQnFeXiKxI&list=PLJ2FoWouEU2w8wnsblKVolmhujkOWgkjo&index=19");
    }

}
