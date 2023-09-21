import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import settings.Settings;


import static constants.authData.EMAIL;
import static constants.authData.PASSWORD;

public class AuthTest extends Settings {

    @Test
    @DisplayName("Авторизация по кнопке 'Войти в аккаунт'")
    @Description("Проверка авторизации по кнопке «Войти в аккаунт» на главной")
    public void authByEnterInAccButton() {
        new MainPage(driver)
                .enterInAccountButtonClick()
                .inputData(EMAIL, PASSWORD)
                .loginButtonClick()
                .goToProfile()
                .checkProfile(EMAIL);
    }

    @Test
    @DisplayName("Авторизация по кнопке 'Личный кабинет'")
    @Description("Проверка авторизации по кнопке «Личный кабинет»")
    public void authByLKButton() {
        new MainPage(driver)
                .accountClick()
                .inputData(EMAIL, PASSWORD)
                .loginButtonClick()
                .goToProfile()
                .checkProfile(EMAIL);
    }

    @Test
    @DisplayName("Авторизация по кнопке в форме регистрации")
    @Description("Проверка авторизации по кнопке в форме регистрации")
    public void authByRegisterFormButton() {
        new MainPage(driver)
                .accountClick()
                .registerClick()
                .enterButtonClick()
                .inputData(EMAIL, PASSWORD)
                .loginButtonClick()
                .goToProfile()
                .checkProfile(EMAIL);
    }
}
