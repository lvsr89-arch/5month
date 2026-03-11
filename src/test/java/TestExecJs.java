import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestExecJs {
    private WebDriver driver;
    String baseUrl = System.getenv("URL");
    private Logger logger = LoggerFactory.getLogger(TestExecJs.class);


    //убрать в env
    private String testName = "Name";
    private String testEmail = "test@email.test";
    private String testPassword = "test";
    private String langLevel = "Средний";
    private String birthdate = "03-12-2026";


    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void feById(String elementName, String elementId) {
        logger.info("Ввожу " + elementId );
        WebElement nameId1 = driver.findElement(By.id(elementId));
        nameId1.sendKeys(elementName);
        Assertions.assertEquals(elementName, nameId1.getAttribute("value"));
    }

    private void assertPasswd (String element1Name,String element2Name){
        WebElement password = driver.findElement(By.id(element1Name));
        WebElement confirmPass = driver.findElement(By.id(element2Name));
        Assertions.assertEquals(
                password.getAttribute("value"),
                confirmPass.getAttribute("value"));
    }

    private void inpLangLvl (String elementName, String elementId) {
        logger.info("Выбрал уровень языка");
        WebElement language = driver.findElement(By.id("language_level"));
        Select select = new Select(language);
        select.selectByVisibleText(langLevel);
    }

    private void inputDate (String elementName, String elementId) {
        logger.info("Ввожу " + elementId );
        WebElement nameId1 = driver.findElement(By.id(elementId));
        nameId1.sendKeys(elementName);
    }

    private void btnClick () {
        logger.info("Жму зерег-ся");
        WebElement regButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        regButton.click();
    }

    private void checkResponse (String ... e) {
        logger.info("Ченкул ответы");
        WebElement output = driver.findElement(By.id("output"));
        String response = output.getText();
        logger.info(response);

        for (String elementId : e) {
            Assertions.assertTrue(response.contains(elementId),
                    "Ответ не содержит ожидаемую часть: '" + elementId + "'");
        }
    }

    @Test
    public void execJs() throws InterruptedException {


        feById(testName,"username");
        feById(testEmail,"email");
        feById(testPassword, "password");
        feById(testPassword, "confirm_password");
        assertPasswd("password","confirm_password");
        inpLangLvl(langLevel, "language_level");
        inputDate(birthdate,"birthdate");
        btnClick();
        checkResponse(testEmail, testName);

        Thread.sleep(2000);

    }
}






//        logger.info("Ввожу имя");
//        WebElement username = driver.findElement(By.id("username"));
//        username.sendKeys(testName);
//        Assertions.assertEquals(testName, username.getAttribute("value"));
//
//        logger.info("Ввожу email");
//        WebElement email = driver.findElement(By.id("email"));
//        email.sendKeys(testEmail);
//        Assertions.assertEquals(testEmail, email.getAttribute("value"));
//
//        logger.info("Ввожу пароль");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys(testPassword);
//        Assertions.assertEquals(testPassword, password.getAttribute("value"));
//
//        logger.info("Ввожу подтверждение пароля");
//        WebElement confirmPass = driver.findElement(By.id("confirm_password"));
//        confirmPass.sendKeys(testPassword);
//        Assertions.assertEquals(testPassword, confirmPass.getAttribute("value"));
//
//        logger.info("Сравниваю пароли");
//        Assertions.assertEquals(
//                password.getAttribute("value"),
//                confirmPass.getAttribute("value"));
//
////        Thread.sleep(2000);
//        logger.info("Указал дату рождения");
//        WebElement date = driver.findElement(By.id("birthdate"));
//        date.sendKeys(birthdate);
////        Thread.sleep(2000);
//
//        logger.info("Выбрал уровень языка");
//        WebElement language = driver.findElement(By.id("language_level"));
//        Select select = new Select(language);
//        select.selectByVisibleText(langLevel);
////        Thread.sleep(2000);
//
//        logger.info("Жму зерег-ся");
//        WebElement regButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
//        regButton.click();
////        Thread.sleep(2000);
//
//        logger.info("Ченкул ответы");
//        WebElement output = driver.findElement(By.id("output"));
//        String response = output.getText();
//        logger.info(response);
//        Thread.sleep(2000);
//        Assertions.assertTrue(response.contains(testName));
//        Thread.sleep(2000);
//        Assertions.assertTrue(response.contains(testEmail));
//        Thread.sleep(2000);