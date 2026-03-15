package factory.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements Isettings {

    @Override
    public AbstractDriverOptions settings(String... args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(args);
        // добавить настройки браузера


        return chromeOptions;
    }
}
