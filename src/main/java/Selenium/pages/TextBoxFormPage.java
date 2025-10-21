package Selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxFormPage extends BasePage {

    @FindBy(css = "input[id='userName']")
    public WebElement fullNameInput;

    @FindBy(id = "input[id='userEmail']")
    public WebElement emailInput;

    @FindBy(id = "input[id='currentAddress']")
    public WebElement currAddressInput;

    @FindBy(id = "input[id='permanentAddress']")
    public WebElement perAddressInput;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

    @FindBy(id = "name")
    public WebElement output;

    public TextBoxFormPage() { //Это конструктор класса TextBoxFormPage
        PageFactory.initElements(driver, this); //в конструкторе вызывается метод PageFactory. Его задача: Автоматически инициализировать поля класса, помеченные аннотациями вроде @FindBy, как объекты WebElement.
        //крч эта строка инициализирует поля класса, помеченные @FindBy, превращая их из null в настоящие WebElement
    }

}
