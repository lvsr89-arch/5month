package factory;

import exceptions.BrowserTypeNotSupportedException;
import factory.settings.ChromeSettings;
import factory.settings.FirefoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private final String browserType = System.getProperty("browser.type").trim().toLowerCase();

    public WebDriver create() {
        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = (ChromeOptions) new ChromeSettings().settings();
                return new ChromeDriver(chromeOptions);


            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = (FirefoxOptions) new FirefoxSettings().settings();
                return new FirefoxDriver(firefoxOptions);
            }
        }
        throw new BrowserTypeNotSupportedException(browserType);
    }
}
