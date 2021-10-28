package screens;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Common;

public class TakeTheBusScreen extends Common {

    public static By takeTheBusChallengeTitle = By.id("bus");
    public static By buttonStartTakeTheBus = By.id("bus_timer_start");
    public static By answer1 = By.xpath("//a[contains(@id,'answer_1')]");
    public static By answer2 = By.xpath("//a[contains(@id,'answer_2')]");
    public static By successModalMessageText = By.xpath("//div[@id='bus_correct_modal']//h5[@id='staticBackdropLabel']");
    public static By successModalPoints = By.xpath("//div[@id='bus_correct_modal']//p[@id='score']");
    public static By failureModalMessageText = By.xpath("//div[@id='bus_incorrect_modal']//h5[@id='staticBackdropLabel']");
    public static By buttonCheckYourFinalScore = By.xpath("//div[@id='bus_correct_modal']//button[@id='leaderboard_link']");
    public static By buttonTryTheNextBattle = By.xpath("//div[@id='bus_correct_modal']//button[@id='close_correct_modal_btn']");
    public static By buttonTryAgain = By.xpath("//div[contains(@id,'correct_modal')]//button[@id='close_incorrect_modal_btn']");
    public static By outOfTimeTryAgain = By.xpath("//div[contains(@id,'out_of_time')]//button[@id='retry']");
    public static By outOfTimeReturnHome = By.xpath("//div[contains(@id,'out_of_time')]//button[contains(@text(),'Return Home')]");

    public static void correctAnswerTakeTheBusChallengeTryNextBattle() {
        driver.findElement(takeTheBusChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartTakeTheBus);
        Assert.assertEquals(driver.findElement(TakeTheBusScreen.buttonStartTakeTheBus).getText(), "Start");
        driver.findElement(buttonStartTakeTheBus).click();
        waitForElementPrescence(driver.findElement(answer1));
        Assert.assertTrue(driver.findElement(answer1).isDisplayed());
        driver.switchTo().defaultContent();
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
        Assert.assertEquals(driver.findElement(successModalMessageText).getText(),"That is correct!");
        Assert.assertTrue(driver.findElement(successModalPoints).getText().contains("you have scored 100 points!"));
        waitForElementPrescence(driver.findElement(buttonTryTheNextBattle));
        driver.findElement(buttonTryTheNextBattle).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://responsivefight.herokuapp.com/restaurant");
    }

    public static void correctAnswerTakeTheBusChallengeCheckYourFinalScore() {
        driver.findElement(takeTheBusChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartTakeTheBus);
        Assert.assertEquals(driver.findElement(TakeTheBusScreen.buttonStartTakeTheBus).getText(), "Start");
        driver.findElement(buttonStartTakeTheBus).click();
        waitForElementPrescence(driver.findElement(answer1));
        Assert.assertTrue(driver.findElement(answer1).isDisplayed());
        driver.switchTo().defaultContent();
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
        Assert.assertEquals(driver.findElement(successModalMessageText).getText(),"That is correct!");
        Assert.assertTrue(driver.findElement(successModalPoints).getText().contains("you have scored 100 points!"));
        waitForElementPrescence(driver.findElement(buttonCheckYourFinalScore));
        driver.findElement(buttonCheckYourFinalScore).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://responsivefight.herokuapp.com/leaderboard");
    }

    public static void incorrectAnswerTakeTheBusChallenge() {
        driver.findElement(takeTheBusChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartTakeTheBus);
        Assert.assertEquals(driver.findElement(TakeTheBusScreen.buttonStartTakeTheBus).getText(), "Start");
        driver.findElement(buttonStartTakeTheBus).click();
        waitForElementPrescence(driver.findElement(answer2));
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
        driver.switchTo().defaultContent();
        String question = driver.findElement(By.xpath("//p[contains(@id,'question')]")).getText();
        By answer = answer2;
        switch (question) {
            case "Someone sits next you, and is beginning to cough, what do you do?":
                answer = answer1;
                break;
            case "You must travel to buy food and medical supplies?":
                break;
            case "You notice a large group of people waiting in line next to each other at a restaurant, what do you do?":
                break;
            case "Your coworker Markus, is constantly coughing in the office, what do you do?":
                break;
            case "You notice one of the waiters serving food is ill and handling orders at a restaurant, what do you do?":
                answer = answer1;
                break;
            case "Fantastic, you have succeeded on all battlefields and have not contracted covid19. A cure is not out there yet so make sure you continue the good work and keep yourself and others safe.":
                break;
            case "It was late in the afternoon, I was in the train returning home like every other day, listening to music and reading the news on my phone, as I was scrolling I saw this article that cough my eye, it said “Chinese authorities treated dozens of cases of pneumonia of unknown cause.” As I read through the article, it sounded like an other case of SARS and thought to myself “this must be due to the poor air quality and conditions in that region!”, I was not really surprised, but little did I know this was only the beginning.":
                break;
            case "As the days pass by I kept researching about what was happening in China, I read about Wuhan and look at some pictures on the internet. It looked like a vibrant and modern city, with strong traditions like markets and architecture. But the cases continue to raise and in January 11th 2020 the first death was published by the still unknown virus that would change my life. Other Countries where starting to report on confirmed cases and it looked like it was quickly spreading around the world.":
                answer = answer1;
                break;
            case "Mary from HR, send a memo advising she is ill and everyone should reach her via email, what do you do?":
                break;
            case "Your Manager Alex, tells you his partner recently came back from overseas, and is seen constantly sneezing during the day, what do you do?":
                answer = answer1;
                break;
            case "You notice the people at the bar are re-using shot glasses for a group round of drinks, what do you do?":
                answer = answer1;
                break;
        }
        driver.findElement(answer).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(driver.findElement(failureModalMessageText));
        Assert.assertEquals(driver.findElement(failureModalMessageText).getText(),"That doesn't sound right!");
        driver.findElement(buttonTryAgain).click();
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
    }

    public static void timeOutTryAgainTakeTheBusChallenge() throws InterruptedException {
        driver.findElement(takeTheBusChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartTakeTheBus);
        Assert.assertEquals(driver.findElement(TakeTheBusScreen.buttonStartTakeTheBus).getText(), "Start");
        driver.findElement(buttonStartTakeTheBus).click();
        waitForElementPrescence(driver.findElement(answer2));
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
        Thread.sleep(10000);
        driver.switchTo().activeElement();
        driver.findElement(outOfTimeTryAgain).click();
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
    }

    public static void timeOutReturnHomeTakeTheBusChallenge() throws InterruptedException {
        driver.findElement(takeTheBusChallengeTitle).click();
        driver.switchTo().activeElement();
        waitForElementPrescence(buttonStartTakeTheBus);
        Assert.assertEquals(driver.findElement(TakeTheBusScreen.buttonStartTakeTheBus).getText(), "Start");
        driver.findElement(buttonStartTakeTheBus).click();
        waitForElementPrescence(driver.findElement(answer2));
        Assert.assertTrue(driver.findElement(answer2).isDisplayed());
        Thread.sleep(10000);
        driver.switchTo().activeElement();
        driver.findElement(outOfTimeReturnHome).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://responsivefight.herokuapp.com/covid");
    }
}
