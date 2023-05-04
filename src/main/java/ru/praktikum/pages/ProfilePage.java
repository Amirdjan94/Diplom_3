package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;
import ru.praktikum.pages.component.HeaderComponent;

public class ProfilePage {
    WebDriver driver;
    User user;
    private HeaderComponent headerComponent;
    private String hidePasswordValue = "*****";
    private By inputLogin = By.xpath(".//label[text()='Логин']/parent::div/input");
    private By inputPassword = By.xpath(".//input[@type='password']");
    private By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    private By logoutBtn = By.xpath(".//button[text()='Выход']");

    public ProfilePage (WebDriver driver, User user) {
        this.driver = driver;
        this.user =user;
        this.headerComponent = new HeaderComponent(driver);
    }

    public boolean isVisibleUserData (){
        return (driver.findElement(inputLogin).getAttribute("value").equals(user.getEmail()) &&
                driver.findElement(inputName).getAttribute("value").equals(user.getName()) &&
                driver.findElement(inputPassword).getAttribute("value").equals(hidePasswordValue));
    }

    public MainPage clickConstructorBtn () {
        headerComponent.clickConstructorBtn();
        return new MainPage(driver, user);
    }

    public MainPage clickLogo () {
        headerComponent.clickLogo();
        return new MainPage(driver, user);
    }

    public AuthorizationPage clickLogoutBtn () {
        driver.findElement(logoutBtn).click();
        return new AuthorizationPage(driver, user);
    }

}
