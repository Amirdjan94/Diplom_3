package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class RegistrationUserTest extends BaseTestWithoutCreateUser {

    @Test
    @DisplayName("Registration user with valid data")
    public void registrationUserTest(){
        boolean isVisibleRegistrationBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .clickRegistrationBtn()
                .registrationUser()
                .isVisibleRegistrationBtn();
        assertTrue("Ошибка при регистрации пользователя с валидными данными", isVisibleRegistrationBtn);

    }

    @Test
    @DisplayName("Registration user with incorrect password")
    public void registrationUserWithIncorrectPasswordTest(){
        boolean isVisibleIncorrectPasswordError = new MainPage(driver, user)
                .clickLoginBtn()
                .clickRegistrationBtn()
                .registrationUserWithIncorrectPassword()
                .isVisibleIncorrectPasswordError();
        assertTrue("Ошибка при регистрации пользователя с некорректным паролем (меньше 6 символов)", isVisibleIncorrectPasswordError);
    }

}