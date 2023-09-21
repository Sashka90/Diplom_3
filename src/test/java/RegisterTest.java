import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import settings.Settings;

public class RegisterTest extends Settings {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка попадания на страницу login после успешной регистрации")
    public void successfulRegisterTest() {
        new MainPage(driver)
                .accountClick()
                .registerClick()
                .inputCorrectData()
                .clickRegisterButton()
                .checkLoginPage();
    }

    @Test
    @DisplayName("Неуспешная регистрация")
    @Description("Проверка ошибки при неккоректном пароле")
    public void incorrectPasswordRegisterTest() {
        new MainPage(driver)
                .accountClick()
                .registerClick()
                .inputIncorrectPasswordData()
                .clickRegisterButton()
                .checkErrorText("Некорректный пароль");
    }
}
