package Selenium.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormsPage extends BasePage {

    @Getter
    private WebElement practiceFormTab = getWebElement(By.xpath("//span[text()='Practice Form']"));

    public PracticeFormPage openPracticeFormPage() {
        openTab(practiceFormTab);
        return new PracticeFormPage();
    }

}
