import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import settings.Settings;

import static constants.authData.EMAIL;
import static constants.authData.PASSWORD;

public class ProfileTest extends Settings {

    @Test
    @DisplayName("Переход в аккаунт по клику на «Личный кабинет»")
    @Description("Проверка что при переходе в аккаунт отображается корректный email")
    public void goToProfileByMainPageButtonTest() {
        new MainPage(driver)
                .userAuth(EMAIL, PASSWORD)
                .goToProfile()
                .checkProfile(EMAIL);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    @Description("Проверка что при клике на конструктор отобразилась главная с секцией конструктора")
    public void goToConstructorByProfileTest() {
        new MainPage(driver)
                .userAuth(EMAIL, PASSWORD)
                .goToProfile()
                .checkProfile(EMAIL)
                .clickToConstructorButton()
                .checkBurgerIngredientsSection();
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    @Description("Проверка перехода на главную после клика по лого")
    public void clickToLogoByProfileTest() {
        new MainPage(driver)
                .userAuth(EMAIL, PASSWORD)
                .goToProfile()
                .clickToLogo()
                .checkMainPage();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверка перехода на страницу login после выхода из профиля")
    public void exitByProfileTest() {
        new MainPage(driver)
                .userAuth(EMAIL, PASSWORD)
                .goToProfile()
                .exitButtonClick()
                .checkLoginPageElements();
    }
}
