package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class OpenConstructorTest extends BaseTestWithCreateUser{

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

}
