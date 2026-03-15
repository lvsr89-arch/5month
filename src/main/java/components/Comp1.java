////package components;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import pageobject.AbsPageObject;
//
//
//import java.util.List;
//
////public class Comp1 extends AbsPageObject {
////
////    public Comp1(WebDriver driver) {
////        super(driver);
////    }
////
////    @FindBy(css = "class=\"fb20e85711 cc6f0e2fc9\"")
////    private List<WebElement> activeSliders;
////
////    public String getSliderItemByIndex(int index) {
////        return activeSliders.get(--index).getText();
////    }
////
////    public ArticlePage clickLinkByTitle(String title) {
////        driver.findElement(By.xpath(String.format("//a[text()='%s']", title))).click();
////
////        return new ArticlePage(driver);
////    }
////}
