package app.forcastie.hooks;

import app.forcastie.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Cucumber hooks won't be used in presentation to speed up the process.
 * Left commented for future normal testing flow
 */

public class CucumberHooks extends BasePage {

//    @Before
//    public static void setUp() throws MalformedURLException {
//        DesiredCapabilities capability = new DesiredCapabilities();
//
//        capability.setCapability(CapabilityType.VERSION,"9");
//        capability.setCapability("app", "/Users/user/IdeaProjects/forcastie/src/test/resources/app.forcastie/apk/app.apk");
//        capability.setCapability("deviceName", "S8");
//        capability.setCapability("platformName", "Android");
//        capability.setCapability("appPackage", "cz.martykan.forecastie");
//        capability.setCapability("appActivity", "cz.martykan.forecastie.activities.SplashActivity");
//
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
//    }
//
//    @After
//    public static void tearDown() {
//        if (driver != null) driver.quit();
//    }
}
