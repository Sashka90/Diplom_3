package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Settings;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    public static Faker faker = new Faker();

    private final By inputName = By.xpath("(//input[@name='name'])[1]");
    private final By inputEmail = By.xpath("(//input[@name='name'])[2]");
    private final By inputPassword = By.xpath("//input[@name='Пароль']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorText = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By enterButton = By.xpath("//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    String name = faker.name().username();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    public RegisterPage inputCorrectData() {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public RegisterPage inputIncorrectPasswordData() {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys("12345");
        return this;
    }

    public RegisterPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return this;
    }

    public LoginPage enterButtonClick() {
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }

    public RegisterPage checkErrorText(String text) {
        Assert.assertEquals(driver.findElement(errorText).getText(), text);
        return this;
    }

    public LoginPage checkLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//h2"), "Вход"));
        Assert.assertEquals(Settings.BASE_URL+"login", driver.getCurrentUrl());
        return new LoginPage(driver);
    }
}
