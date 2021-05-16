package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

import java.io.File;

public class BrowserSetup {

    public static WebDriver webDriver;
    static String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + File.separator;

    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }

    public static WebDriver firefoxDriver() {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        webDriver = new FirefoxDriver();
        return webDriver;
    }

    public static WebDriver edgeDriver() {
        System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--disable-notifications");
        webDriver = new EdgeDriver(edgeOptions);
        return webDriver;
    }

}
