package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.AreYouGameChallengeScreen;
import screens.LoginScreen;
import screens.TakeTheBusScreen;
import utils.Common;
import utils.SetDriver;

public class TakeTheBusTests extends Common {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        SetDriver.setDriver(browser);
        driver.get("https://responsivefight.herokuapp.com/");
    }

    @Test
    public void test_01_verifyCorrectAnswerTakeTheBusChallengeTryNextBattle() {
        LoginScreen.loginToApp("Hercules");
        TakeTheBusScreen.correctAnswerTakeTheBusChallengeTryNextBattle();
    }

    @Test
    public void test_02_verifyCorrectAnswerTakeTheBusChallengeCheckYourFinalScore() {
        LoginScreen.loginToApp("Hercules");
        TakeTheBusScreen.correctAnswerTakeTheBusChallengeCheckYourFinalScore();
    }

    @Test
    public void test_03_verifyIncorrectAnswerTakeTheBusChallenge() {
        LoginScreen.loginToApp("Hercules");
        TakeTheBusScreen.incorrectAnswerTakeTheBusChallenge();
    }

    @Test
    public void test_04_verifyTimeoutTryAgain() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        TakeTheBusScreen.timeOutTryAgainTakeTheBusChallenge();
    }

    @Test
    public void test_05_verifyTimeoutReturnHome() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        TakeTheBusScreen.timeOutReturnHomeTakeTheBusChallenge();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
