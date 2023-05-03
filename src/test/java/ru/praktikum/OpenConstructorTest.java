package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;
import ru.praktikum.data.UserGenerator;
import ru.praktikum.extensions.WebDriverFactory;
import ru.praktikum.pages.MainPage;
import ru.praktikum.user.UserAction;

import static org.junit.Assert.assertTrue;

public class OpenConstructorTest {
    private WebDriver driver;
    private User user;
    private UserAction userAction;
    @Before
    public void init() {
        driver = WebDriverFactory.get();
        userAction = new UserAction();
        user = UserGenerator.getUser();
        userAction.createUser(user);
    }
    @Test
    @DisplayName("Open constructor from constructor button")
    public void openConstructorFromConstructorBtnTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .loginUser()
                .clickProfileBtnWithAuth()
                .clickConstructorBtn()
                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка при переходе  из личного кабинета в конструктор по клику на «Конструктор»", isVisibleCreateOrderBtn);
    }
    @Test
    @DisplayName("Open constructor from logo button")
    public void openConstructorFromLogoTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .loginUser()
                .clickProfileBtnWithAuth()
                .clickLogo()
                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка при переходе  из личного кабинета в конструктор по клику на логотип", isVisibleCreateOrderBtn);
    }

    @After
    public void tearDown() {
        driver.quit();
        userAction.deleteUser(userAction.login(user));
    }
}
