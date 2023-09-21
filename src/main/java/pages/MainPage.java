package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Settings;

import java.time.Duration;

public class MainPage {

   WebDriver driver;

    private final By accountButton = By.xpath("//a[@href='/account']");
    private final By enterInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By burgerIngredientsSection = By.xpath("//section[contains(@class, 'BurgerIngredients')]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterInAccountButtonClick() {
        driver.findElement(enterInAccountButton).click();
        return new LoginPage(driver);
    }

    public LoginPage accountClick() {
        driver.findElement(accountButton).click();
        return new LoginPage(driver);
    }

    public ProfilePage goToProfile() {
        accountClick();
        return new ProfilePage(driver);
    }

    public MainPage userAuth(String email, String pass) {
        accountClick();
        new LoginPage(driver).inputData(email, pass)
                .loginButtonClick();
        return new MainPage(driver);
    }

    public MainPage checkBurgerIngredientsSection() {
        Assert.assertTrue(driver.findElement(burgerIngredientsSection).isDisplayed());
        return this;
    }

    public MainPage checkMainPage() {
        Assert.assertEquals(Settings.BASE_URL, driver.getCurrentUrl());
        return this;
    }

    public MainPage clickToConstructorTab(String tabName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterInAccountButton));
        driver.findElement(By.xpath("//span[text()='"+tabName+"']/parent::*")).click();
        return this;
    }

    public MainPage checkActiveConstructorTab(String tabName) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'tab_tab_type_current')]/child::span[text()='"+tabName+"']")).isDisplayed());
        return this;
    }
}
