package Factory;

import Factory.impl.BrowserSettings;
import Factory.impl.ChromeSettings;
import Factory.impl.FirefoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverFactory {
    private final Browser browser = Browser.valueOf(System.getProperty("browser").toUpperCase());
    private final WebDriverManager webDriverManager = getWebDriverManager();
    private final BrowserSettings<?> browserSettings = getBrowserSettings();


    public WebDriver create() {
        WebDriver driver = webDriverManager.capabilities(browserSettings.configureDriver()).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    private WebDriverManager getWebDriverManager() {
        return switch (browser) {
            case CHROME -> WebDriverManager.chromedriver();
            case EDGE -> WebDriverManager.edgedriver();
            case FIREFOX -> WebDriverManager.firefoxdriver();
        };
    }

    private BrowserSettings<?> getBrowserSettings() {
        return switch (browser) {
            case CHROME -> new ChromeSettings();
            case FIREFOX -> new FirefoxSettings();
            case EDGE -> null;
        };
    }

    private enum Browser {
        CHROME,
        FIREFOX,
        EDGE
    }
}
