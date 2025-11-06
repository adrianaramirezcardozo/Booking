package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class SearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "searchbox_destination")
    private RemoteWebElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sort\")")
    private RemoteWebElement sortButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Distance From Downtown\")")
    private RemoteWebElement distanceFromDowntownOption;

    @AndroidFindBy(id = "facet_with_bui_free_search_booking_header_toolbar_content")
    private RemoteWebElement destinationField;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)")
    private RemoteWebElement firstCity;

    @AndroidFindBy(id = "calendar_month_list")
    private RemoteWebElement calendarMonthList;

    @AndroidFindBy(id = "facet_date_picker_confirm")
    private RemoteWebElement confirmDatesButton;

    @AndroidFindBy(accessibility = "1 room · 2 adults · 0 children")
    private RemoteWebElement roomsAndGuestField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(0)")
    private RemoteWebElement addRoomButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(1)")
    private RemoteWebElement addAdultButton;

    @AndroidFindBy(id = "group_config_apply_button")
    private RemoteWebElement confirmRoomAndGuestsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(3)")
    private RemoteWebElement searchButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(5)")
    private RemoteWebElement addToWishlistButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement navigateUpButton;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean searchFieldTextIs(String expectedText) {
        new WebDriverWait(driver, GlobalVariables.longTimeout)
                .until(ExpectedConditions.visibilityOf(searchField));
        return searchField.getAttribute("text").equals(expectedText);
    }
    @Step("Clicking Sort button")
    public void clickSortButton() {
        sortButton.click();
    }

    @Step("Choosing distance from Downtown")
    public void chooseDistanceFromDowntown() {
        new WebDriverWait(driver, GlobalVariables.longTimeout)
                .until(ExpectedConditions.visibilityOf(distanceFromDowntownOption));
        distanceFromDowntownOption.click();
    }
    @Step("Entering destination")
    public void enterDestination(String title) {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.longTimeout);
        wait.until(ExpectedConditions.visibilityOf(destinationField));
        destinationField.clear();
        destinationField.sendKeys(title);
    }
    @Step("Opening first city")
    public void openFirstCity() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.longTimeout);
        wait.until(ExpectedConditions.visibilityOf(firstCity));
        firstCity.click();
    }
    @Step("Calendar Month List is displayed")
    public boolean calendarMonthList() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(calendarMonthList)).isDisplayed();
    }
    @Step("Confirming dates")
    public void confirmDates() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.longTimeout);
        wait.until(ExpectedConditions.visibilityOf(confirmDatesButton));
        confirmDatesButton.click();
    }
    @Step("Opening Room and guests")
    public void openRoomAndGuestsField() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.longTimeout);
        wait.until(ExpectedConditions.visibilityOf(roomsAndGuestField));
        roomsAndGuestField.click();
    }
    @Step("Adding rooms")
    public void addRoom() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(addRoomButton));
        addRoomButton.click();
    }
    @Step("Adding adults")
    public void addAdult() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(addAdultButton));
        addAdultButton.click();
    }

    @Step("Confirming rooms and guests")
    public void confirmRoomsAndGuests() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(confirmRoomAndGuestsButton));
        confirmRoomAndGuestsButton.click();
    }
    @Step("Searching booking")
    public void searchBooking() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
    @Step("Adding to wishlist")
    public void addToWhishlist() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.longTimeout);
        wait.until(ExpectedConditions.visibilityOf(addToWishlistButton));
        addToWishlistButton.click();
    }

    @Step("Navigating back")
    public void navigateUp() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(navigateUpButton));
        navigateUpButton.click();
    }
}