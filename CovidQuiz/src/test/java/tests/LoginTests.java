package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.LoginScreen;
import utils.Common;
import utils.SetDriver;

public class LoginTests extends Common {

    @BeforeMethod
    public void setUp() {
        SetDriver.setDriver("chrome");
        driver.get("https://responsivefight.herokuapp.com/");
    }

    @Test
    public void test_01_PageTitle() {
        WebElement pageTitleText = driver.findElement(LoginScreen.pageTitle);
        Assert.assertTrue(pageTitleText.getText().contains("COVID-19 THE GAME"));
    }

    @Test
    public void test_02_NullWarriorName() {
        LoginScreen.loginToApp("");
    }

    @Test
    public void test_03_WarriorNameWithMoreThan10Characters() {
        LoginScreen.loginToApp("Hercules12345");
    }

    @Test
    public void test_04_ValidWarriorName() {
        LoginScreen.loginToApp("Hercules");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
