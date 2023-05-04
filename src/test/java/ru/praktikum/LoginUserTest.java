package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginUserTest extends BaseTestWithCreateUser{

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

}
