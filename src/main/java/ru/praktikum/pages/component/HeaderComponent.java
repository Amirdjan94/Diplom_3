package ru.praktikum.pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent {
    private WebDriver driver;
    private By proifilePageBtn =  By.xpath(".//a[@href='/account']");
    private By constructorBtn = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    private By logoBtn = By.xpath(".//div[starts-with(@class, 'AppHeader_header__logo')]");
    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogo(){
        driver.findElement(logoBtn).click();
    }
    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }
    public void clickProifilePageBtn () {
        driver.findElement(proifilePageBtn).click();
    }

}
