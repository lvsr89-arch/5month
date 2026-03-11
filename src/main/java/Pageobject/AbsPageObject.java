package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbsPageObject {

    protected final WebDriver driver;
    protected final CommonWaiter waiter;

    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new CommonWaiter(driver);

    }
}
