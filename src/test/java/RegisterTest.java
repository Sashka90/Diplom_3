import api.User;
import api.UserApi;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class RegisterTest  {

    WebDriver driver;
    UserApi userApi = new UserApi();
    public static Faker faker = new Faker();

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    String name = faker.name().username();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
        Response loginResponse = userApi.login(new User(name, email, password));
        String accessToken = loginResponse.then().extract().path("accessToken");
        if (accessToken != null) {
            userApi.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка попадания на страницу login после успешной регистрации")
    public void successfulRegisterTest() {
        new MainPage(driver)
                .accountClick()
                .registerClick()
                .inputData(name, email, password)
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
                .inputData(name, email, "12345")
                .clickRegisterButton()
                .checkErrorText("Некорректный пароль");
    }
}
