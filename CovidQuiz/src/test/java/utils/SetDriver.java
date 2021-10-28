package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.Objects;

public class SetDriver {

    public static WebDriver driver;

    public static void setDriver(String browser) {
        String driverPath = System.getProperty("user.dir");
        System.out.println(driverPath);
        if (Objects.equals(browser, "chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/src/test/java/utils/chromedriver");
            driver = new ChromeDriver();
        } else if (Objects.equals(browser, "firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "/src/test/java/utils/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
