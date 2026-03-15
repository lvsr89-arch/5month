package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pageobject.AbsPageObject;
import factory.WebDriverFactory;

public class Form extends AbsPageObject {

    // ХЗ, не понял как лучше сделать привязку: локатор - вводные данные
    private final String login = System.getProperty("login");
    private final String email = System.getProperty("email");
    private final String password = System.getProperty("password");
    private final String langLevel = "Средний";
    private final String date = "10-03-2003";
    private final String browserType = driver.toString().toLowerCase();

    public Form(WebDriver driver) {
        super(driver);
    }

    private void feById(String elementName, String elementId) {
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
        WebElement language = driver.findElement(By.id(elementId));
        Select select = new Select(language);
        select.selectByVisibleText(elementName);
    }

    private void inputDate (String elementName, String elementId) {
        WebElement nameId1 = driver.findElement(By.id(elementId));
        if (browserType.contains("chrome")) {
            nameId1.sendKeys(elementName);
        } else {
            nameId1.sendKeys(convertDate(elementName));
        }


    }

    private void btnClick () {
        WebElement regButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        regButton.click();
    }

    private String convertDate (String inpDate) {
        String[] temp = inpDate.split("-");
        return temp[2] + "-" + temp[1] + "-" + temp[0];
    }

    public void enterValues() {
        System.out.println("ВЫВОЖУ " + login + " " + email + " " + password);
        feById(login,"username");
        feById(email,"email");
        feById(password, "password");
        feById(password, "confirm_password");
        assertPasswd("password","confirm_password");
        inpLangLvl(langLevel, "language_level");
        inputDate(date,"birthdate");
    }

    public void pushTheButton() {
            btnClick();
    }

    public void checkCorrect() {
        String[] output = driver.findElement(By.id("output")).getText().split("\n");
        Assertions.assertTrue(output[0].trim().contains(login));
        Assertions.assertTrue(output[1].trim().contains(email));
        Assertions.assertTrue(output[2].trim().contains(convertDate(date)));
        Assertions.assertTrue(output[3].trim().contains("intermediate"));
    }
}
