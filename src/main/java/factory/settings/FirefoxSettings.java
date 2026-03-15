package factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements Isettings {

    @Override
    public AbstractDriverOptions settings(String... args) {

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(args);
        // добавить настройки браузера

        return firefoxOptions;
    }
}
