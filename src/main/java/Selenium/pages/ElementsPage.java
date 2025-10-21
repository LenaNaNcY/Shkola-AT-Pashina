package Selenium.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BasePage {

    @Getter
    private WebElement textBoxTab = getWebElement(By.xpath("//span[text()='Text Box']"));

    @Getter
    private WebElement checkBoxTab = getWebElement(By.xpath("//span[text()='Check Box']"));

    @Getter
    private WebElement radioBtnTab = getWebElement(By.xpath("//span[starts-with( . , 'Radio')]"));

    @Getter
    private WebElement webTablTab = getWebElement(By.xpath("//span[text()='Web Tables']"));

    @Getter
    private WebElement buttonsTab = getWebElement(By.xpath("//span[text()='Buttons']"));

    @Getter
    private WebElement linksTab = getWebElement(By.xpath("//span[text()='Links']"));

    @Getter
    private WebElement brokenLinksTab = getWebElement(By.xpath("//span[starts-with( . , 'Broken')]"));

    @Getter
    private WebElement uploadTab = getWebElement(By.xpath("//span[starts-with( . , 'Upload')]"));

    @Getter
    private WebElement cPropertiesTab = getWebElement(By.xpath("//span[text()='c Properties']"));

    public TextBoxFormPage openTextBoxPage() {
        openTab(textBoxTab);
        return new TextBoxFormPage();
    }


}
