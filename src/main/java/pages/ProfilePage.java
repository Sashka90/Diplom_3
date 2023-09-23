package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;

    private final By profileLogin = By.xpath("//input[@name='name']");
    private final By exitButton = By.xpath("//button[text()='Выход']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By logo = By.xpath("//div[contains(@class, 'logo')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage checkProfile(String login) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(exitButton));
        Assert.assertEquals(login, driver.findElement(profileLogin).getAttribute("value"));
        return this;
    }

    public MainPage clickToConstructorButton() {
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }

    public MainPage clickToLogo() {
        driver.findElement(logo).click();
        return new MainPage(driver);
    }

    public LoginPage exitButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }
}
