package mainPage;

import components.Form;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPage_Test extends AbsBaseTest{

    @Test
    public void clickArticle() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        Form form = new Form(driver);
        form.enterValues();
        form.pushTheButton();
        form.checkCorrect();


        //        Comp1 comp1 = new Comp1(driver);
//        String title = comp1.getSliderItemByIndex(1);
//        comp1
//                .clickLinkByTitle(title)
//                .pageHeaderShouldBeSameAs(title);
    }
}
