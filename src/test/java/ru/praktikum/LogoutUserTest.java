package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LogoutUserTest extends BaseTestWithCreateUser{

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

}
