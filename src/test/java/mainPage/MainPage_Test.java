package mainPage;

import components.Form;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPage_Test extends AbsBaseTest{

    @Test
    public void mainPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        Form form = new Form(driver);
        form.enterValues();
        form.pushTheButton();
        form.checkCorrect();
    }
}
