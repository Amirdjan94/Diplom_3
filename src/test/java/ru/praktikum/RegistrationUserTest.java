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

public class RegistrationUserTest {
    private WebDriver driver;
    private User user;
    private UserAction userAction;
    @Before
    public void init() {
        driver = WebDriverFactory.get();

        userAction = new UserAction();
        user = UserGenerator.getUser();
    }
    @Test
    @DisplayName("Registration user with valid data")
    public void registrationUserTest(){
        boolean isVisibleRegistrationBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .clickRegistrationBtn()
                .registrationUser()
                .isVisibleRegistrationBtn();
        assertTrue("Ошибка при регистрации пользователя с валидными данными", isVisibleRegistrationBtn);

        userAction.deleteUser(userAction.login(user));
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

    @After
    public void tearDown() {
        driver.quit();
    }
}