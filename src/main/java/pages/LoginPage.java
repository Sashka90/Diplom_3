package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    private final By registerButton = By.xpath("//a[@href='/register']");
    private final By inputEmail = By.xpath("//input[@name='name']");
    private final By inputPassword = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputData(String email, String pass) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(pass);
        return this;
    }

    public MainPage loginButtonClick() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    public RegisterPage registerClick() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public LoginPage checkLoginPageElements() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//h2"), "Вход"));
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
        Assert.assertTrue(driver.findElement(inputEmail).isDisplayed());
        Assert.assertTrue(driver.findElement(inputPassword).isDisplayed());
        return this;
    }
}
