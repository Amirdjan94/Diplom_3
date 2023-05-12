package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;


public class AuthorizationPage {
    WebDriver driver;
    User user;
    private By btnRegistration = By.xpath(".//a[text()='Зарегистрироваться']");
    private By btnLogin =By.xpath(".//button[text()='Войти']");
    private By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private By inputPassword = By.xpath(".//input[@type='password']");
    private By forgotPasswordBtn = By.xpath(".//a[@href='/forgot-password']");

    public AuthorizationPage (WebDriver driver, User user) {
        this.driver = driver;
        this.user =user;
    }

    public RegistrationPage clickRegistrationBtn(){
        driver.findElement(btnRegistration).click();
        return new RegistrationPage(driver, user);
    }

    public void clickLoginBtn(){
        driver.findElement(btnLogin).click();
    }

    public ForgotPasswordPage clickForgotPasswordBtn(){
        driver.findElement(forgotPasswordBtn).click();
        return new ForgotPasswordPage(driver, user);
    }

    public boolean isVisibleRegistrationBtn () {
        return driver.findElement(btnLogin).isDisplayed();
    }
    public void fillDataLogin(String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);

    }

    public MainPage loginUser() {
        fillDataLogin(user.getEmail(), user.getPassword());
        clickLoginBtn();
        return new MainPage(driver, user);
    }

}
