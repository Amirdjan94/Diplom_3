package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.data.User;
import ru.praktikum.pages.component.HeaderComponent;

import static ru.praktikum.data.Const.WAIT_TIMEOUT;

public class MainPage {
    private WebDriver driver;
    private User user;
    private HeaderComponent headerComponent;
    private By btnLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    private By btnCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    private By souceSectionBtn = By.xpath(".//span[text()='Соусы']");
    private By bunSectionBtn = By.xpath(".//span[text()='Булки']");
    private By fillingSectionBtn = By.xpath(".//span[text()='Начинки']");
    private By souceSection = By.xpath(".//span[text()='Соусы']/parent::div[contains (@class, 'current')]");
    private By bunSection = By.xpath(".//span[text()='Булки']/parent::div[contains (@class, 'current')]");
    private By fillingSection = By.xpath(".//span[text()='Начинки']/parent::div[contains (@class, 'current')]");

    public MainPage (WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        this.headerComponent = new HeaderComponent(driver);
    }

    public AuthorizationPage clickLoginBtn(){
        driver.findElement(btnLogin).click();
        return  new AuthorizationPage(driver, user);
    }

    public AuthorizationPage clickProfileBtnWithoutAuth(){
        headerComponent.clickProifilePageBtn();
        return  new AuthorizationPage(driver, user);
    }

    public ProfilePage clickProfileBtnWithAuth(){
        headerComponent.clickProifilePageBtn();
        return  new ProfilePage(driver, user);
    }

    public boolean isVisibleCreateOrderBtn () {
        return driver.findElement(btnCreateOrder).isDisplayed();
    }
    public MainPage clickSouceSectionBtn(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(souceSectionBtn));
        driver.findElement(souceSectionBtn).click();
        return new MainPage(driver, user);
    }

    public MainPage clickBunSectionBtn(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(bunSectionBtn));
        driver.findElement(bunSectionBtn).click();
        return new MainPage(driver, user);
    }

    public MainPage clickFillingSectionBtn(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(fillingSectionBtn));
        driver.findElement(fillingSectionBtn).click();
        return new MainPage(driver, user);
    }

    public boolean isVisibleSouceSection(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(souceSection));
        return driver.findElement(souceSection).isDisplayed();
    }

    public boolean isVisibleBunSection(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bunSection));
        return driver.findElement(bunSection).isDisplayed();
    }

    public boolean isVisibleFillingSection(){
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fillingSection));
        return driver.findElement(fillingSection).isDisplayed();
    }

}
