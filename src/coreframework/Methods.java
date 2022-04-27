package coreframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Methods extends Superclass{
    public void ClickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void ClickByID(String id){
        driver.findElement(By.xpath(id)).click();
    }
    public void Sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void SendKeys(String xpath,String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public String GetText(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public String GetAttribute(String xpath,String attribute){
       return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }
    public void WaitUntilXpath(String xpath){
        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void LogFile(String scenarioName){
        SimpleDateFormat formatter=new SimpleDateFormat("d-MMM-YY HH-mm");
        Date date=new Date(System.currentTimeMillis());
        File file=new File("ConsoleOutput\\"+scenarioName+formatter.format(date)+".txt");
        PrintStream stream=null;
        try {
            stream=new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(stream);
    }

}
