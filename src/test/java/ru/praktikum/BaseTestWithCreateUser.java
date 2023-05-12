package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.data.User;
import ru.praktikum.data.UserGenerator;
import ru.praktikum.extensions.WebDriverFactory;
import ru.praktikum.user.UserAction;

public class BaseTestWithCreateUser {
    public WebDriver driver;
    public User user;
    public UserAction userAction;

    @Before
    public void init() {
        driver = WebDriverFactory.get();
        userAction = new UserAction();
        user = UserGenerator.getUser();
        userAction.createUser(user);
    }

    @After
    public void tearDown() {
        driver.quit();
        userAction.deleteUser(userAction.login(user));
    }
}
