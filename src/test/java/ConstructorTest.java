import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import settings.Settings;

public class ConstructorTest extends Settings {

    @Test
    @DisplayName("Перемещение по вкладкам ингредиентов бургера")
    @Description("Проверка активности вкладки после клика по ней")
    public void constructorTabsTest() {
        new MainPage(driver)
                .checkActiveConstructorTab("Булки")
                .clickToConstructorTab("Соусы")
                .checkActiveConstructorTab("Соусы")
                .clickToConstructorTab("Начинки")
                .checkActiveConstructorTab("Начинки");
    }
}
