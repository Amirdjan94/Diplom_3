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

public class LogoutUserTest {
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
    @DisplayName("Check logout user from profile")
    public void logoutFromProfileTest(){
        boolean isVisibleRegistrationBtn = new MainPage(driver, user)
                .clickLoginBtn()
                .loginUser()
                .clickProfileBtnWithAuth()
                .clickLogoutBtn()
                .isVisibleRegistrationBtn();
        assertTrue("Ошибка при выходе из аккаунта", isVisibleRegistrationBtn);
    }

    @After
    public void tearDown() {
        driver.quit();
        userAction.deleteUser(userAction.login(user));
    }
}
