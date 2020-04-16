package app.forcastie.pages;

import org.openqa.selenium.By;

public class SettingsPage extends BasePage {

    By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    By temperatureButton = By.xpath("//android.widget.TextView[contains(@text,'Temperature units')]");
    By selectCelsius = By.xpath("//android.widget.CheckedTextView[contains(@text,'Celsius')]");
    By selectFahrenheit = By.xpath("//android.widget.CheckedTextView[contains(@text,'Fahrenheit')]");
    By selectKelvin = By.xpath("//android.widget.CheckedTextView[contains(@text,'Kelvin')]");

    public void changeTempScale(String scale) {
        click(temperatureButton);
        switch (scale) {
            case "Celsius":
                click(selectCelsius);
                break;
            case "Fahrenheit":
                click(selectFahrenheit);
                break;
            case "Kelvin":
                click(selectKelvin);
                break;
        }
    }

    public void goBack() {
        click(backButton);
    }
}
