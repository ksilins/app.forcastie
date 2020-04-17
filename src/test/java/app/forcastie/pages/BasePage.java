package app.forcastie.pages;

import app.forcastie.model.City;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    public static WebDriver driver;
    public static City city = new City();

    public void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public void sendKeys(By element, String inputText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(inputText);
    }

    public String getTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    public void setUp() {
        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setCapability(CapabilityType.VERSION, "9");
        capability.setCapability("app", "/Users/user/app-debug.apk");
        capability.setCapability("deviceName", "S8");
        capability.setCapability("platformName", "Android");
        capability.setCapability("appPackage", "cz.martykan.forecastie");
        capability.setCapability("appActivity", "cz.martykan.forecastie.activities.SplashActivity");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
