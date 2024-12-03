package QaCartCousre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenHtmlFile {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //Open Html using selenium in chrome => locate the file in project and use "file://absolute path"
        driver.get("file:///home/mariam/Work/Learning/Testing/Automation_Rania_Mokhtar/Java/shopping_website/src/test/java/QaCartCousre/index.html");

        //Maximize the window
        driver.manage().window().maximize();

        //Full screen view
        driver.manage().window().fullscreen();
    }

    @Test
    public void getName() {
        System.out.println("hello");
    }
}
