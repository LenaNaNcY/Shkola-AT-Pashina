package Lection4JUnit5_2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.*;

    //1. Добавляю остальные 3 коллбэка после BeforeAll
public class L5_HomeworkSetUpBrowserExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback, AfterAllCallback {

    //2.Создаю в экстеншене нэймспейс, тк на лекции нам сказали, что это важно, тк это как бы айдишник каждого экстеншна
    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(L5_HomeworkSetUpBrowserExtension.class);
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadTimeout = 20000;
        //2. Добавила строчку ниже, тк без неё тесты не проходятся
        Configuration.pageLoadStrategy = "eager";
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    //3. Продолжаю использовать оставшиеся методы жизненного цикла из BaseTest:

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Selenide.open("https://demoqa.com/");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception{
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}

