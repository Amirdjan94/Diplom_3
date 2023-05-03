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

public class OpenIngridientsSectionTest {
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

    @After
    public void tearDown() {
        driver.quit();
    }
}
