package coreframework;

import io.cucumber.java.Scenario;
import io.cucumber.java.AfterStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class BrowserFactory {
    public static WebDriver driver;
    public void launchTheApp(){
        if(ReadProperties.get("Browser").contains("Chrome")){
            System.setProperty("webdriver.chrome.driver",ReadProperties.get("ChromeDriver"));
            driver=new ChromeDriver();
            driver.get(ReadProperties.get("URL"));
            driver.manage().window().maximize();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }



}
