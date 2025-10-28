package com.example.Selenium;

import Selenium.driver.WebDriverManager;
import Selenium.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPageObjectTests {

    @Test
void test() {
        DemoqaPage demoqaPage = new BasePage().openDemoqaPage();
        Assertions.assertTrue(demoqaPage.getWidgetsTab().isDisplayed(), "Карточка с названием Widgets присутствует");

        //это просто в качестве примера перед глазами перенесла из лекции
//        ElementsPage elementsPage = demoqaPage.openElementsPage();
//        Assertions.assertTrue(elementsPage.getCheckBoxTab().isEnabled(), "Карточка с названием CheckBox доступна");
//        Assertions.assertEquals("Radio Button", elementsPage.getRadioBtnTab().getText(), "Неверное название карточки Radio Button");

//        TextBoxFormPage textBoxFormPage = elementsPage.openTextBoxPage();
//        textBoxFormPage.fillField(textBoxFormPage.fullNameInput, "Елена");
//        textBoxFormPage.submitBtn.click();
//        Assertions.assertEquals("Name:Елена", textBoxFormPage.output.getText(), "Название не соответствует введённому значению");
//        textBoxFormPage.close();

        FormsPage formsPage = demoqaPage.openFormsPage();
        PracticeFormPage practiceFormPage = formsPage.openPracticeFormPage();

            // Заполнить форму
            practiceFormPage.fillForm(
                    "Елена",
                    "Пашина",
                    "elena@example.com",
                    "1234567890",
                    "16 Mar 1991" // формат, который принимает поле (может потребовать коррекции)
//                   "АТ"
//                    "г. Александров, СНТ Искож-1",
//                    "NCR",
//                    "Delhi"
            );

      //      practiceFormPage.submitButton.click(); - перенесла в метод заполнить форму


        // Проверить данные в модальном окне
        Assertions.assertTrue(practiceFormPage.modalContent.isDisplayed(), "Модальное окно не отобразилось");
        Assertions.assertEquals("Елена Пашина", practiceFormPage.modalName.getText().trim());
        Assertions.assertEquals("elena@example.com", practiceFormPage.modalEmail.getText().trim());
        Assertions.assertEquals("Female", practiceFormPage.modalGender.getText().trim());
        Assertions.assertEquals("1234567890", practiceFormPage.modalMobile.getText().trim());

        // Закрыть модальное окно
        practiceFormPage.closeModalButton.click();

        // Проверить, что форма сброшена
        Assertions.assertTrue(practiceFormPage.isFormReset(), "Форма не сброшена после отправки");

    }
    }


