package screens;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Common;

import java.util.Iterator;
import java.util.Set;

public class AreYouGameChallengeScreen extends Common {

    public static By challengeTitle = By.id("news");
    public static By buttonStartAreYouGame = By.xpath("//button[contains(@id,'start')]");
    public static By answer1 = By.id("answer_1");
    public static By answer2 = By.id("answer_2");
    public static By successModalMessageText = By.xpath("//div[@id='correctModal']//h5[@id='staticBackdropLabel']");
    public static By failureModalMessageText = By.xpath("//div[@id='incorrectModal']//h5[@id='staticBackdropLabel']");
    public static By buttonGoHomeAndStartAgain = By.id("close_modal_btn_2");
    public static By buttonContinueSuccessModal = By.xpath("//div[@id='correctModal']//button[@id='continue']");

    public static void correctAnswerAreYouGameChallenge() {
        driver.findElement(challengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartAreYouGame);
        Assert.assertEquals(driver.findElement(AreYouGameChallengeScreen.buttonStartAreYouGame).getText(), "Start");
        driver.findElement(buttonStartAreYouGame).click();
        driver.switchTo().defaultContent();
        waitForElementPrescence(driver.findElement(answer1));
        String question = driver.findElement(By.xpath("//p[contains(@id,'question')]")).getText();
        By answer = answer1;
        switch (question) {
            case "Someone sits next you, and is beginning to cough, what do you do?":
                answer = answer2;
                break;
            case "You must travel to buy food and medical supplies?":
                break;
            case "You notice a large group of people waiting in line next to each other at a restaurant, what do you do?":
                break;
            case "Your coworker Markus, is constantly coughing in the office, what do you do?":
                break;
            case "You notice one of the waiters serving food is ill and handling orders at a restaurant, what do you do?":
                answer = answer2;
                break;
            case "Fantastic, you have succeeded on all battlefields and have not contracted covid19. A cure is not out there yet so make sure you continue the good work and keep yourself and others safe.":
                break;
            case "It was late in the afternoon, I was in the train returning home like every other day, listening to music and reading the news on my phone, as I was scrolling I saw this article that cough my eye, it said “Chinese authorities treated dozens of cases of pneumonia of unknown cause.” As I read through the article, it sounded like an other case of SARS and thought to myself “this must be due to the poor air quality and conditions in that region!”, I was not really surprised, but little did I know this was only the beginning.":
                break;
            case "As the days pass by I kept researching about what was happening in China, I read about Wuhan and look at some pictures on the internet. It looked like a vibrant and modern city, with strong traditions like markets and architecture. But the cases continue to raise and in January 11th 2020 the first death was published by the still unknown virus that would change my life. Other Countries where starting to report on confirmed cases and it looked like it was quickly spreading around the world.":
                answer = answer2;
                break;
            case "Mary from HR, send a memo advising she is ill and everyone should reach her via email, what do you do?":
                break;
            case "Your Manager Alex, tells you his partner recently came back from overseas, and is seen constantly sneezing during the day, what do you do?":
                answer = answer2;
                break;
            case "You notice the people at the bar are re-using shot glasses for a group round of drinks, what do you do?":
                answer = answer2;
                break;
        }
        driver.findElement(answer).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(driver.findElement(successModalMessageText));
        Assert.assertEquals(driver.findElement(successModalMessageText).getText(), "That is correct!");
        Assert.assertTrue(driver.findElement(successModalMessageText).isDisplayed());
        waitForElementPrescence(driver.findElement(buttonContinueSuccessModal));
        driver.findElement(buttonContinueSuccessModal).click();
        waitForElementPrescence(driver.findElement(answer));
    }

    public static void incorrectAnswerAreYouGameChallenge() {
        driver.findElement(challengeTitle).click();
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
        Assert.assertEquals(driver.findElement(failureModalMessageText).getText(), "Oh no!");
        Assert.assertTrue(driver.findElement(failureModalMessageText).isDisplayed());
        driver.findElement(buttonGoHomeAndStartAgain).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://responsivefight.herokuapp.com/");
    }
}
