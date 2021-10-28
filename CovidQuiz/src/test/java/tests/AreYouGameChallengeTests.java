package tests;

import com.thoughtworks.qdox.model.expression.LogicalNot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AreYouGameChallengeScreen;
import screens.LoginScreen;
import utils.Common;
import utils.SetDriver;

public class AreYouGameChallengeTests extends Common {

    @BeforeMethod
    public void setUp() {
        SetDriver.setDriver("chrome");
        driver.get("https://responsivefight.herokuapp.com/");
    }

    @Test
    public void test_01_verifyCorrectAnswerAreYouGameChallenge() {
        LoginScreen.loginToApp("Hercules");
        AreYouGameChallengeScreen.correctAnswerAreYouGameChallenge();
    }

    @Test
    public void test_02_verifyIncorrectAnswerAreYouGameChallenge() {
        LoginScreen.loginToApp("Hercules");
        AreYouGameChallengeScreen.incorrectAnswerAreYouGameChallenge();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
