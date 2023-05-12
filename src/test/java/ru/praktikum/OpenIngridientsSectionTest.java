package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class OpenIngridientsSectionTest extends BaseTestWithoutCreateUser{

    @Test
    @DisplayName("Open bun section in constructor")
    public void openBunSectionTest(){
        boolean isVisibleBunSection = new MainPage(driver, user)
                .clickFillingSectionBtn()
                .clickBunSectionBtn()
                .isVisibleBunSection();
        assertTrue("Ошибка при переходе к разделу Булки", isVisibleBunSection);
    }

    @Test
    @DisplayName("Open souce section in constructor")
    public void openSouceSectionTest(){
        boolean isVisibleSouceSection = new MainPage(driver, user)
                .clickSouceSectionBtn()
                .isVisibleSouceSection();
        assertTrue("Ошибка при переходе к разделу Соусы", isVisibleSouceSection);
    }

    @Test
    @DisplayName("Open filling section in constructor")
    public void openFillingSectionTest(){
        boolean isVisibleFillingSection = new MainPage(driver, user)
                .clickFillingSectionBtn()
                .isVisibleFillingSection();
        assertTrue("Ошибка при переходе к разделу Начинки", isVisibleFillingSection);
    }
}
