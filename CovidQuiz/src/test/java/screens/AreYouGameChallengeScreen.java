package screens;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Common;

import java.util.Iterator;
import java.util.Set;

public class AreYouGameChallengeScreen extends Common {

    public static By areYouGameChallengeTitle = By.id("news");
    public static By buttonStartAreYouGame = By.id("start");
    public static By answer1 = By.id("answer_1");
    public static By answer2 = By.id("answer_2");
    public static By successModalMessageText = By.xpath("//div[@id='correctModal']//h5[@id='staticBackdropLabel']");
    public static By failureModalMessageText = By.xpath("//div[@id='incorrectModal']//h5[@id='staticBackdropLabel']");
    public static By buttonGoHomeAndStartAgain = By.id("close_modal_btn_2");
    public static By buttonContinueSuccessModal = By.xpath("//div[@id='correctModal']//button[@id='continue']");

    public static void correctAnswerAreYouGameChallenge() {
        driver.findElement(areYouGameChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartAreYouGame);
        Assert.assertEquals(driver.findElement(AreYouGameChallengeScreen.buttonStartAreYouGame).getText(), "Start");
        driver.findElement(buttonStartAreYouGame).click();
        waitForElementPrescence(driver.findElement(answer1));
        Assert.assertTrue(driver.findElement(answer1).isDisplayed());
        driver.switchTo().defaultContent();
        driver.findElement(answer1).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(driver.findElement(successModalMessageText));
        Assert.assertEquals(driver.findElement(successModalMessageText).getText(),"That is correct!");
        Assert.assertTrue(driver.findElement(successModalMessageText).isDisplayed());
        waitForElementPrescence(driver.findElement(buttonContinueSuccessModal));
        driver.findElement(buttonContinueSuccessModal).click();
        waitForElementPrescence(driver.findElement(answer2));
    }

    public static void incorrectAnswerAreYouGameChallenge() {
        driver.findElement(areYouGameChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartAreYouGame);
        Assert.assertEquals(driver.findElement(AreYouGameChallengeScreen.buttonStartAreYouGame).getText(), "Start");
        driver.findElement(buttonStartAreYouGame).click();
        waitForElementPrescence(driver.findElement(answer2));
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
        driver.switchTo().defaultContent();
        driver.findElement(answer2).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(driver.findElement(buttonGoHomeAndStartAgain));
        waitForElementPrescence(driver.findElement(failureModalMessageText));
        Assert.assertEquals(driver.findElement(failureModalMessageText).getText(),"Oh no!");
        Assert.assertTrue(driver.findElement(failureModalMessageText).isDisplayed());
        driver.findElement(buttonGoHomeAndStartAgain).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://responsivefight.herokuapp.com/");
    }
}
