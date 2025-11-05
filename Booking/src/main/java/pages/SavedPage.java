package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;


public class SavedPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "wishlist_name")
    private RemoteWebElement myNextTripTitle;

    public SavedPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Next trip is displayed")
    public boolean myNextTripTitleIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.longTimeout).until(ExpectedConditions.visibilityOf(myNextTripTitle)).isDisplayed();
    }
}
