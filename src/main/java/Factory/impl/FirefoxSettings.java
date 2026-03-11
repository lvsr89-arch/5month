package Factory.impl;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSettings implements BrowserSettings<FirefoxOptions> {

    @Override
    public FirefoxOptions configureDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }
}
