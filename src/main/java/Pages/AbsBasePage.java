package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    protected final String baseUrl = System.getProperty("base.url");

    @FindBy(tagName = "h1")
    private WebElement header;

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void open(String ... args);

    public void pageHeaderShouldBeSameAs(String value) {
        assertThat(header).as("Обнаружен пустой заголовок").isNotNull();
        assertThat(header.getText()).as("Неожиданный текст заголовка").isEqualTo(value);
    }

}
