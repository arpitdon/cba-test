package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.AreYouGameChallengeScreen;
import screens.GoToAPublicPlaceScreen;
import screens.LoginScreen;
import screens.TakeTheBusScreen;
import utils.Common;
import utils.SetDriver;

public class GoToAPublicPlaceTests extends Common {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        SetDriver.setDriver(browser);
        driver.get("https://responsivefight.herokuapp.com/");
    }

    @Test
    public void test_01_verifyCorrectAnswerPublicPlaceChallengeTryNextBattle() {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.correctAnswerPublicPlaceChallengeTryNextBattle();
    }

    @Test
    public void test_02_verifyCorrectAnswerPublicPlaceChallengeCheckYourFinalScore() {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.correctAnswerPublicPlaceChallengeCheckYourFinalScore();
    }

    @Test
    public void test_03_verifyIncorrectAnswerPublicPlaceChallenge() {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.incorrectAnswerPublicPlaceChallenge();
    }

    @Test
    public void test_04_verifyTimeoutTryAgain() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.timeOutTryAgainPublicPlaceChallenge();
    }

    @Test
    public void test_05_verifyTimeoutReturnHome() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.timeOutReturnHomePublicPlaceChallenge();
    }

    @Test
    public void test_06_verifyScoreShouldBe100() throws InterruptedException {
        LoginScreen.loginToApp("Hercules");
        GoToAPublicPlaceScreen.checkScore();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
