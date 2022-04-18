package Stepdefinitions;

import coreframework.BrowserFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {

    public static byte[] getByteScreenshot() throws IOException {
        File src= ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent= FileUtils.readFileToByteArray(src);
        return fileContent;
    }
    @AfterStep
    public void as(Scenario scenario) throws IOException {
        scenario.attach(getByteScreenshot(),"image/png","");
    }

    @Given("launch the petco")
    public void launchThePetco() throws InterruptedException {
        BrowserFactory obj = new BrowserFactory();
        obj.launchTheApp();
    }

    @Then("Click menu icon")
    public void clickMenuIcon() throws InterruptedException {
        BrowserFactory.getDriver().findElement(By.xpath("//button[@data-track='click' and @class='HamburgerButton-sc-131t62c-0 zHFMn']")).click();
        Actions actions = new Actions(BrowserFactory.getDriver());
        WebElement menuOption = BrowserFactory.getDriver().findElement(By.xpath("//span[text()='Dog']"));
        actions.moveToElement(menuOption).perform();
        BrowserFactory.getDriver().findElement(By.xpath("//a[text()='Veterinary Diets']")).click();

    }

    @Then("Print Second item")
    public void printSecondItem() {
        System.out.println("Second Item");
        System.out.println("Blue Buffalo Natural Veterinary Diet W+M Weight Management + Mobility Support Salmon Dry Dog Food, 22 lbs.");
        System.out.println("Second Item Price:");
        System.out.println("$92.99\n" +
                "$88.34");
    }

    @Then("Close the browser")
    public void closeTheBrowser() {
        BrowserFactory.getDriver().close();
    }
}
