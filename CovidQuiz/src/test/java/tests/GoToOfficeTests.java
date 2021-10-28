package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.GoToOfficeScreen;
import screens.LoginScreen;
import utils.Common;
import utils.SetDriver;

public class GoToOfficeTests extends Common {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        SetDriver.setDriver(browser);
        driver.get("https://responsivefight.herokuapp.com/");
    }

    @Test
    public void test_01_verifyCorrectAnswerOfficeChallengeTryNextBattle() {
        LoginScreen.loginToApp("Hercules");
        GoToOfficeScreen.correctAnswerOfficeChallengeTryNextBattle();
    }

    @Test
    public void test_02_verifyCorrectAnswerOfficeChallengeCheckYourFinalScore() {
        LoginScreen.loginToApp("Hercules");
        GoToOfficeScreen.correctAnswerOfficeChallengeCheckYourFinalScore();
    }

    @Test
    public void test_03_verifyIncorrectAnswerOfficeChallenge() {
        LoginScreen.loginToApp("Hercules");
        GoToOfficeScreen.incorrectAnswerOfficeChallenge();
    }

    @Test
    public void test_04_verifyTimeoutTryAgain() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        GoToOfficeScreen.timeOutTryAgainOfficeChallenge();
    }

    @Test
    public void test_05_verifyTimeoutReturnHome() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        GoToOfficeScreen.timeOutReturnHomeOfficeChallenge();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
