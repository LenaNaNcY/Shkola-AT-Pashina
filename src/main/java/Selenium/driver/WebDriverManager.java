package Selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverManager {

    public static WebDriver initWebdriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--high-dpi-support=1");
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return driver;
        }


//    DRAFT - пример из лекции:
//    WebDriver driver = null;
//    try {
//        // мы не указываем путь путь к драйверу вручную — Selenium 4.21.0 делает это сам
//        //    System.setProperty("webdriver.chrome.driver", "C:\\Users\\epashina\\Desktop\\Unikredit\\Shkola_AT_v2\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver(); // создаём экземпляр драйвера
//        // настройки браузера:
//        driver.manage().deleteAllCookies(); // удаление всех кук
//        driver.manage().window().maximize(); // работа с окном
//        driver.get("https://demoqa.com/"); // передача урла
//        // неявное ожидание:
//        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); - это зачёркивается, гугл говорит, оно устарело => добавила внизу современную форму
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        // return driver; - можно это раскомментить, а строки 11-12 и с 25й закомментить
//    }
//    catch(Exception e) {
//        e.printStackTrace();
//        if (driver != null) {
//            driver.quit(); // закрываем, только если драйвер был создан
//        }
//        throw new RuntimeException("Failed to initialize WebDriver", e);
//    }
//    return driver;
}

