package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions action;


    public void hold(int x){
        try {
            Thread.sleep(Duration.ofSeconds(x));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeBrowser(String browser) {
        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}