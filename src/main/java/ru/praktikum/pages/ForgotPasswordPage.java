package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;

public class ForgotPasswordPage {
    private WebDriver driver;
    private User user;
    private By loginBtn = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
    }

    public AuthorizationPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new AuthorizationPage(driver, user);
    }

}
