package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends AbsBasePage {

    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver, "/" + System.getProperty("main.path"));
        logger.info("Открываю страницу");
    }
}
