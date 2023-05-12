package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;
import ru.praktikum.data.UserGenerator;
import ru.praktikum.extensions.WebDriverFactory;
import ru.praktikum.user.UserAction;

public class BaseTestWithoutCreateUser {
    public WebDriver driver;
    public User user;
    public UserAction userAction;

    @Before
    public void init() {
        userAction = new UserAction();
        driver = WebDriverFactory.get();
        user = UserGenerator.getUser();
    }

    @After
    public void tearDown() {
        if (userAction.login(user).then().extract().path("success").toString().equals("true")) {
            userAction.deleteUser(userAction.login(user));
        }
        driver.quit();
    }
}
