package Components;

import Pageobject.AbsPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AbsComponent extends AbsPageObject {

    protected WebElement root;

    public AbsComponent(WebDriver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void click() {
        waiter.waitForCondition(ExpectedCondition.stalenessOf(root));
        root.click();
    }

    public String getText() {
        return root.getText();
    }
}
