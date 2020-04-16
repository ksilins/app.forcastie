package app.forcastie.stepDefs;

import app.forcastie.pages.LocationsPage;
import app.forcastie.pages.MainPage;
import app.forcastie.pages.SettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmokeTestSteps {

    MainPage mainPage = new MainPage();
    LocationsPage location = new LocationsPage();
    SettingsPage settings = new SettingsPage();

    @Given("^I'm on main page$")
    public void iMOnMainPage() {
        mainPage.verifyMainPage();
    }

    @When("search for {word}")
    public void tryToFindCity(String cityName) {
        mainPage.openSearchBox();
        mainPage.searchInput(cityName);
    }

    @And("select it from locations")
    public void selectFirstOption() {
        location.selectOption();
    }

    @Then("selected city weather is shown")
    public void selectedCityWeatherIsShown() {
        mainPage.assertCity();
    }

    @When("I tap refresh button")
    public void iTapRefreshButton() {
        mainPage.updateWeatherData();
    }

    @Then("weather report is updated")
    public void weatherReportIsUpdated() {
        mainPage.assertUpdateTime();
    }

    @When("I tap on {word} tab")
    public void iTapOnDayTab(String day) {
        mainPage.switchDayTabs(day);
    }

    @Then("{word} weather is shown")
    public void correctDayWeatherIsShown(String day) {
        mainPage.assertDayTab(day);
    }

    @Given("app is opened")
    public void appIsOpened() {
        mainPage.appIsOpened();
    }

    @When("I set temperature scale to {word}")
    public void iSetTemperatureScaleTo(String scale) {
        mainPage.openOptionsMenu();
        mainPage.tapSettingsMenu();
        settings.changeTempScale(scale);
    }

    @And("return to main page")
    public void returnToMainPage() {
        settings.goBack();
        mainPage.verifyMainPage();
    }

    @Then("temperature is shown {word}")
    public void temperatureIsShownFahrenheit(String scale) {
        mainPage.assertTemperatureScale(scale);
    }
}
