package Selenium.pages;

import Selenium.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected static WebDriver driver = WebDriverManager.initWebdriver();

    private String basePageUrl = "https://demoqa.com/"; // прописываем урл базовой стартовой страницы

    public DemoqaPage openDemoqaPage() { // метод открывает стартовую страницу
        driver.get(basePageUrl);
        return new DemoqaPage();
    }

    public void openTab(WebElement webElement) { // метод открывает вкладку
        webElement.click();
    }

    public void fillField(WebElement element, String text) { // метод заполняет поле
        element.sendKeys(text);
    }

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public void close() {
        driver.quit();
    }
}
