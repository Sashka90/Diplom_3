import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import settings.Settings;

public class ConstructorTest extends Settings {

    @Test
    @DisplayName("Перемещение по вкладкам ингредиентов бургера")
    @Description("Проверка активности первой вкладки 'Булки' по умолчаию")
    public void constructorDefaultActiveFirstTabTest() {
        new MainPage(driver)
                .checkActiveConstructorTab("Булки");
    }

    @Test
    @DisplayName("Перемещение по вкладкам ингредиентов бургера")
    @Description("Проверка активности второй вкладки 'Соусы' по клику на нее")
    public void constructorActiveSecondTabTest() {
        new MainPage(driver)
                .clickToConstructorTab("Соусы")
                .checkActiveConstructorTab("Соусы");
    }

    @Test
    @DisplayName("Перемещение по вкладкам ингредиентов бургера")
    @Description("Проверка активности третей вкладки 'Начинки' по клику на нее")
    public void constructorActiveThirdTadTest() {
        new MainPage(driver)
                .clickToConstructorTab("Начинки")
                .checkActiveConstructorTab("Начинки");
    }
}
