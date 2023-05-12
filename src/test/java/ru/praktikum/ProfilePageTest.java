package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ProfilePageTest extends BaseTestWithCreateUser{

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

}
