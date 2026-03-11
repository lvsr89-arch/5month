package Pages;

import org.openqa.selenium.WebDriver;

public class ArticlePage extends AbsBasePage{

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public void open(String... args) {
        driver.get(baseUrl + "/article/" + args[0]);
    }
}
