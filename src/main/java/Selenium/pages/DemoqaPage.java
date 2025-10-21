package Selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage extends BasePage {

    @Getter
    @FindBy (xpath = "//h5[text()= 'Elements']")
    private WebElement elementsTab;

    @Getter
    @FindBy (xpath = "//h5[text()= 'Forms']")
    private WebElement formsTab;

    @Getter
    @FindBy (xpath = "//h5[text()= 'Alerts, Frame & Windows']")
    private WebElement alertsTab;

    @Getter
    @FindBy (xpath = "//h5[text()= 'Widgets']")
    private WebElement widgetsTab;

    @Getter
    @FindBy (xpath = "//h5[text()= 'Interactions']")
    private WebElement interactionsTab;

    @Getter
    @FindBy (xpath = "//h5[starts-with( . , 'Book')]")
    private WebElement bookStoreAppTab;

    public DemoqaPage() {
        PageFactory.initElements(driver, this);
    }

//    По идее это нам прописывать не нужно, тк в BasePage есть метод openTab?
    public ElementsPage openElementsPage() {
        openTab(elementsTab);
        return new ElementsPage();
    }

    public FormsPage openFormsPage() {
        openTab(formsTab);
        return new FormsPage();
    }

}
