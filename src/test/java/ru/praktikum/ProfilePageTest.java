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

public class ProfilePageTest {
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
    @DisplayName("Open profile with authorization")
    public void openProfilePageWithAuthTest(){
        boolean isVisibleUserData = new MainPage(driver, user)
                .clickLoginBtn()
                .loginUser()
                .clickProfileBtnWithAuth()
                .isVisibleUserData();
        assertTrue("Ошибка при переходе в личный кабинет с авторизованным пользователем", isVisibleUserData);
    }

    @Test
    @DisplayName("Open profile without authorization")
    public void openProfilePageWithoutAuthTest(){
        boolean isVisibleRegistrationBtn = new MainPage(driver, user)
                .clickProfileBtnWithoutAuth()
                .isVisibleRegistrationBtn();
        assertTrue("Ошибка при переходе в личный кабинет с НЕ авторизованным пользователем", isVisibleRegistrationBtn);
    }

    @After
    public void tearDown() {
        driver.quit();
        userAction.deleteUser(userAction.login(user));
    }
}
