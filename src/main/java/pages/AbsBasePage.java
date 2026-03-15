package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private final String baseUrl = System.getenv("base_url");

    private String path;

//        @FindBy(tagName = "h1")
//        private WebElement header;

    public void open() {
        driver.get(baseUrl + path);
    }

//    public void pageHeaderShouldBeSameAs(String expectedHeader) {
//        Assertions.assertEquals(expectedHeader, header.getText(), String.format("Header should be sameAs %s", expectedHeader));
//    }

}
