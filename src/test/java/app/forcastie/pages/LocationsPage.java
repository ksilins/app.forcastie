package app.forcastie.pages;

import org.openqa.selenium.By;

public class LocationsPage extends BasePage {

    public void selectOption() {
        click(By.xpath("//android.widget.TextView[@resource-id='cz.martykan.forecastie:id/rowCityTextView' " +
                "and contains(@text,'" + city.getName() + "')]"));
    }
}
