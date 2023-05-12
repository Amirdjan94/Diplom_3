package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;

import static ru.praktikum.data.Const.INCORRECT_PASSWORD_ERROR;

public class RegistrationPage {
    private WebDriver driver;
    private User user;
    private String incorrectPassword = "12345";
    private By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    private By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private By inputPassword = By.xpath(".//input[@type='password']");
    private By btnRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private By incorrectPassworError = By.className("input__error");
    private By loginBtn = By.xpath(".//a[@href='/login']");


    public RegistrationPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user =user;
    }

    public void clickRegistrationBtn(){
        driver.findElement(btnRegistration).click();
    }

    public void fillDataRegistration(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
    }

    public AuthorizationPage registrationUser(){
        fillDataRegistration(user.getName(), user.getEmail(), user.getPassword());
        clickRegistrationBtn();
        return new AuthorizationPage(driver, user);
    }

    public RegistrationPage registrationUserWithIncorrectPassword(){
        fillDataRegistration(user.getName(), user.getEmail(), incorrectPassword);
        clickRegistrationBtn();
        return this;
    }

    public boolean isVisibleIncorrectPasswordError(){
        return driver.findElement(incorrectPassworError).getText().equals(INCORRECT_PASSWORD_ERROR);
    }

    public AuthorizationPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new AuthorizationPage(driver, user);
    }

}
