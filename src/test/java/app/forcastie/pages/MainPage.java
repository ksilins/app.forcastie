package app.forcastie.pages;

import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    By currentWeatherIcon = By.id("todayIcon");
    By currentCity = By.xpath("//*[@resource-id='cz.martykan.forecastie:id/toolbar']/android.widget.TextView");
    By currentTemperature = By.xpath("//android.widget.TextView[@resource-id='cz.martykan.forecastie:id/todayTemperature']");
    By searchButton = By.id("action_search");
    By searchInputField = By.xpath("//android.widget.EditText");
    By searchOkButton = By.id("android:id/button1");
    By refreshButton = By.id("cz.martykan.forecastie:id/action_refresh");
    By lastUpdate = By.id("cz.martykan.forecastie:id/lastUpdate");
    By todayTab = By.xpath("//android.support.v7.app.ActionBar.Tab[1]");
    By tomorrowTab = By.xpath("//android.support.v7.app.ActionBar.Tab[2]");
    By laterTab = By.xpath("//android.support.v7.app.ActionBar.Tab[3]");
    By optionsButton = By.xpath("//android.widget.ImageView[@content-desc='More options']");
    By settingsButton = By.xpath("//android.widget.TextView[contains(@text,'Settings')]");

    public void verifyMainPage() {
        waitFor(currentWeatherIcon);
    }

    public void openSearchBox() {
        click(searchButton);
    }

    public void searchInput(String cityName) {
        city.setName(cityName);
        click(searchInputField);
        sendKeys(searchInputField, cityName);
        click(searchOkButton);
    }

    public void assertCity() {
        waitFor(currentCity);
        String cityName = driver.findElement(currentCity).getText();
        assertThat(cityName).contains(city.getName());
    }

    public void updateWeatherData() {
        click(refreshButton);
    }

    public void assertUpdateTime() {
        waitFor(lastUpdate);
        assertThat(driver.findElement(lastUpdate).getText()).contains(getTime());
        tearDown();
    }

    public void switchDayTabs(String day) {
        switch (day) {
            case "today":
                click(todayTab);
                break;
            case "tomorrow":
                click(tomorrowTab);
                break;
            case "later":
                click(laterTab);
                break;
        }
    }

    public void assertDayTab(String day) {
        switch (day) {
            case "today":
                assertThat(driver.findElement(todayTab).isSelected()).isTrue();
                break;
            case "tomorrow":
                assertThat(driver.findElement(tomorrowTab).isSelected()).isTrue();
                break;
            case "later":
                assertThat(driver.findElement(laterTab).isSelected()).isTrue();
                break;
        }
    }

    public void appIsOpened() {
        setUp();
        waitFor(currentWeatherIcon);
    }

    public void openOptionsMenu() {
        click(optionsButton);
    }

    public void tapSettingsMenu() {
        click(settingsButton);
    }

    public void assertTemperatureScale(String scale) {
        String currentTemp = driver.findElement(currentTemperature).getText();
        switch (scale) {
            case "Celsius":
                assertThat(currentTemp).contains("°C");
                break;
            case "Fahrenheit":
                assertThat(currentTemp).contains("°F");
                break;
            case "Kelvin":
                assertThat(currentTemp).contains("KK");
                break;
        }
    }
}
