package ru.praktikum.extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.data.Const.BASE_URI;
import static ru.praktikum.data.Const.WAIT_TIMEOUT;

public class WebDriverFactory {
    public static WebDriver get() {
        WebDriver driver;
        String browserName = System.getenv().get("browser");
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe"); // Тут нужно указать ссылку на бинарный файл Chrome, который соответсует версии chrome использумаемы на вашем яндекс браузере
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\Smena\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); //Тут нужно указать ссылку на бинарный файл яндекс браузера
                driver = new ChromeDriver(options);
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.get(BASE_URI);
        return driver;
    }
}
