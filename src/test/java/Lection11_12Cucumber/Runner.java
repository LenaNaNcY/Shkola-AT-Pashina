package Lection11_12Cucumber;


import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite //это для запуска класса раннер, если закомментить - пропадёт зеленый треугольник
@IncludeEngines("cucumber") //показывает, какой движок у нас буде работать
@SelectClasspathResource("features") //путь до папки со сценариями
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "Lection11_12Cucumber.steps") //указываем папку, где шаги - там же и Хукс, тк в нём тоже можно писать шаги
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false") //не обязат; если сделать тру - будет показывать при запуске, какие шаги у нас ещё не реализованы
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Cucumber-tests") //эта аннотация говорит, какие тесты будем гонять, с какими тегами - у нас это верхнеуровневый тег Функционала в фича-файле, там все тесты прогонятся
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm") //это что-то для отчёта
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")


public class Runner {
}
