package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage extends BasePage {

    @FindBy(css = "input[id='firstName']")
    public WebElement firstNameInput;

    @FindBy(css = "input[id='lastName']")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

//    @FindBy(xpath = "//div[@class='col-md-9 col-sm-12']//input[@type='radio']")
//    public List<WebElement> genderRadioButtons;

    //Лучше так, типа сразу опишем тестовый выбор элемента
    @FindBy(xpath = "//label[text()='Female']")
    public WebElement genderFemaleLabel;

//    Или мб так?
//    @FindBy(xpath = "//label[text()='Male']/preceding-sibling::input[@type='radio']")
//    public WebElement genderMaleRadioButton;
//
//    @FindBy(xpath = "//label[text()='Female']/preceding-sibling::input[@type='radio']")
//    public WebElement genderFemaleRadioButton;
//
//    @FindBy(xpath = "//label[text()='Other']/preceding-sibling::input[@type='radio']")
//    public WebElement genderOtherRadioButton;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput") //прокатит ли так, когда просто id = , ьез квадратных скобок?
    public WebElement subjectsInput;

//    @FindBy(xpath = "//div[@class='col-md-9 col-sm-12']//input[@type='c' or @type='checkbox']")
//    public List<WebElement> hobbiesCheckBox;

    //Лучше так, типа сразу опишем тестовый выбор элемента
    @FindBy(id = "hobbies-checkbox-1") // Sports
    public WebElement hobbiesSportsCheckbox;

//    Или так?
//    @FindBy(xpath = "//label[text()='Sports']/preceding-sibling::input[@type='checkbox']")
//    public WebElement hobbiesSportsCheckBox;
//
//    @FindBy(xpath = "//label[text()='Reading']/preceding-sibling::input[@type='checkbox']")
//    public WebElement hobbiesReadingCheckBox;
//
//    @FindBy(xpath = "//label[text()='Music']/preceding-sibling::input[@type='checkbox']")
//    public WebElement hobbiesMusicCheckBox;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureInput;

    @FindBy(id = "currentAddress")
    public WebElement currAddressTextarea;

    @FindBy(id = "react-select-3-input") // State dropdown input (React-Select)
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input") // City dropdown input
    public WebElement cityInput;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;


    // Модалка
    @FindBy(css = ".modal-content")
    public WebElement modalContent;

    @FindBy(id = "closeLargeModal")
    public WebElement closeModalButton;

    // TТабличка в модалке для проверки
    @FindBy(xpath = "//tbody//tr[1]//td[2]") // Name
    public WebElement modalName;

    @FindBy(xpath = "//tbody//tr[2]//td[2]") // Email
    public WebElement modalEmail;

    @FindBy(xpath = "//tbody//tr[3]//td[2]") // Gender
    public WebElement modalGender;

    @FindBy(xpath = "//tbody//tr[4]//td[2]") // Mobile
    public WebElement modalMobile;

    public PracticeFormPage() { //Это конструктор класса
        PageFactory.initElements(driver, this); //в конструкторе вызывается метод PageFactory. Его задача: Автоматически инициализировать поля класса, помеченные аннотациями вроде @FindBy, как объекты WebElement.
        //крч эта строка инициализирует поля класса, помеченные @FindBy, превращая их из null в настоящие WebElement
    }

    // Заполняем форму
    public boolean fillForm(String firstName, String lastName, String email, String mobile, String dob) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        genderFemaleLabel.click(); // выбираем Female
        userNumberInput.sendKeys(mobile);

        // ДР
        dateOfBirthInput.click();
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys(dob);
        dateOfBirthInput.sendKeys(Keys.ENTER);

//        // Предмет
//        subjectsInput.sendKeys(subject);
//        subjectsInput.sendKeys(Keys.ENTER);

        // Хобби
       // hobbiesSportsCheckbox.click(); - не работало, ошибка Element <input type="checkbox" id="hobbies-checkbox-1" class="custom-control-input" value="1"> is not clickable at point (744, 577). Other element would receive the click: <td>...</td>
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesSportsCheckbox);

//        // Адрес
//        currAddressTextarea.sendKeys(address);

//        // State & City
//        stateInput.sendKeys(state);
//        stateInput.sendKeys(Keys.ENTER);
//        cityInput.sendKeys(city);
//        cityInput.sendKeys(Keys.ENTER);

        // submitButton.click(); //ошибка "Element <button id="submit" type="submit" class="btn btn-primary">...</button> is not clickable at point (1370, 884). Other element would receive the click: <div>...</div>"
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        return true;
    }



    // Проверяем что форма сбросилась
    public boolean isFormReset() {
        return firstNameInput.getAttribute("value").isEmpty() &&
                lastNameInput.getAttribute("value").isEmpty() &&
                emailInput.getAttribute("value").isEmpty() &&
                userNumberInput.getAttribute("value").isEmpty() &&
                currAddressTextarea.getText().isEmpty() &&
                !genderFemaleLabel.isSelected() &&
                !hobbiesSportsCheckbox.isSelected() &&
                submitButton.isEnabled();
    }


}

