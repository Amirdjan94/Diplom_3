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

public class LoginUserTest {
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
    @DisplayName("Check login user from main page")
    public void loginUserFromMainPageTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .loginUser()
                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка авторизации пользователя по кнопке «Войти в аккаунт» на главной странице", isVisibleCreateOrderBtn);
    }
    @Test
    @DisplayName("Check login user from profile button")
    public void loginUserFromProfileBtnTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickProfileBtnWithoutAuth()
                        .loginUser()
                                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка авторизации пользователя через кнопку «Личный кабинет»",isVisibleCreateOrderBtn);
    }
    @Test
    @DisplayName("Check login user from registration page")
    public void loginUserFromRegistrationPageTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickProfileBtnWithoutAuth()
                .clickRegistrationBtn()
                .clickLoginBtn()
                .loginUser()
                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка авторизации пользователя через кнопку в форме регистрации",isVisibleCreateOrderBtn);
    }
    @Test
    @DisplayName("Check login user from forgot password page")
    public void loginUserFromForgotPasswordPageTest(){
        boolean isVisibleCreateOrderBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .clickForgotPasswordBtn()
                .clickLoginBtn()
                .loginUser()
                .isVisibleCreateOrderBtn();
        assertTrue("Ошибка авторизации пользователя через кнопку в форме восстановления пароля",isVisibleCreateOrderBtn);
    }


    @After
    public void tearDown() {
        driver.quit();
        userAction.deleteUser(userAction.login(user));
    }
}
