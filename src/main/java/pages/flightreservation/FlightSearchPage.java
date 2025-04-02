package pages.flightreservation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(passengersSelect));
        return passengersSelect.isDisplayed();
    }

    public void selectPassengers(String numberOfPassengers) {
        Select select = new Select(this.passengersSelect);
        select.selectByValue(numberOfPassengers);
    }

    public void searchFlight() {
        searchFlightsButton.sendKeys(Keys.PAGE_DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.searchFlightsButton.click();
    }
}
