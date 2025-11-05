package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;


public class HomePage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "bt_accept")
    private RemoteWebElement acceptCookiesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in and save money\")")
    private RemoteWebElement signInPopup;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Need ideas?\")")
    private RemoteWebElement needIdeasSection;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Granada\")")
    private RemoteWebElement fourthCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Enter your destination\")")
    private RemoteWebElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/navigation_bar_item_icon_view\").instance(1)")
    private RemoteWebElement savedBookingTab;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Sign In Popup is displayed")
    public boolean signInPopUpIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.longTimeout).until(ExpectedConditions.visibilityOf(signInPopup)).isDisplayed();
    }
    @Step("Sign In Popup is not displayed")
    public boolean signInPopUpIsNotDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.longTimeout)
                .until(ExpectedConditions.invisibilityOf(signInPopup));
    }

    @Step("Popup is ignored")
    public void ignorePopUp() {
        tapAtCoordinates(driver, 524, 664);
    }
    @Step("Navigating to bottom")
    public void navigateToBottom() {
        swipeVertically(driver, Directions.UP);
    }
    public boolean needIdeasSectionIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.longTimeout).until(ExpectedConditions.visibilityOf(needIdeasSection)).isDisplayed();
    }
    @Step("Navigating to 4th card")
    public void navigateToFourthCard() {
        swipeHorizontallyMultipleTimes(driver, Directions.LEFT, 2);
    }
    @Step("Opening to 4th card")
    public void openFourthCard() {
        fourthCard.click();
    }
    @Step("Opening destination")
    public void openDestination() {
        searchField.click();
    }

    @Step("Opening Saved Booking Tab")
    public void openSavedBookingTab() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.shortTimeout);
        wait.until(ExpectedConditions.visibilityOf(savedBookingTab));
        savedBookingTab.click();
    }
}