package pages;

import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private final String baseUrl = System.getProperty("base.url");

    private String path;

    public void open() {
        driver.get(baseUrl + path);
    }

}
