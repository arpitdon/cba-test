package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Common;

public class LoginScreen extends Common {

    public static By pageTitle = By.xpath("//p[@class='option-label']");
    public static By textBoxUserName = By.id("worrior_username");
    public static By buttonCreateWarrior = By.id("warrior");
    public static By welcomeText = By.id("welcome_text");
    public static By buttonAreYouGame = By.id("news");
    public static By buttonStart = By.partialLinkText("Start your journey");

    public static void loginToApp(String warriorName){
        waitForElementPrescence(textBoxUserName);
        WebElement userName = driver.findElement(textBoxUserName);
        userName.sendKeys(warriorName);
        WebElement buttonCreateWarrior = driver.findElement(LoginScreen.buttonCreateWarrior);
        waitForElementPrescence(buttonCreateWarrior);
        buttonCreateWarrior.click();
        WebElement buttonStart = driver.findElement(LoginScreen.buttonStart);
        waitForElementPrescence(buttonStart);
        if(warriorName.equals("")){
            Assert.assertEquals(buttonStart.getText(), "Start your journey guest");
        }else if(warriorName.length()>10){
            warriorName = warriorName.substring(0, 10);
            Assert.assertEquals(buttonStart.getText(), "Start your journey " + warriorName);
        }else{
            Assert.assertEquals(buttonStart.getText(), "Start your journey " + warriorName);
        }
        buttonStart.click();
        waitForElementPrescence(welcomeText);
    }
}
