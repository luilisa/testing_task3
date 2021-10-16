package org.example;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginTest {

    @BeforeClass
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.downloadsFolder = "C:\\Users\\User\\IdeaProjects\\test_task3";

        open(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        webdriver().shouldHave(url("https://kpfu.ru/"));
        LoginPage loginPage = new LoginPage();
        loginPage.clickAccount();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }
    @Step ("Проверка имени")
    public void checkName(String currentName) {
        Assert.assertEquals("Хайбуллина Луиза Юнировна",currentName);
    }

    @Test
    public void checkUser()  {
        ProfilePage profilePage = new ProfilePage();
//        profilePage.perfomanceClick();
        profilePage.homeClick();
        String user = profilePage.getUserName();
        checkName(user);
        profilePage.uploadPhoto();ZZ
    }

    @Test
    public void checkFile() {
        ProfilePage profilePage = new ProfilePage();
        Assert.assertTrue(profilePage.checkFile());
    }

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
