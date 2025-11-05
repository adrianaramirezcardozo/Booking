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
public class NotificationsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Not now\")")
    private RemoteWebElement notNowButton;

    public NotificationsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Setting Notifications later")
    public void setNotificationsLater() {
        new WebDriverWait(driver, GlobalVariables.longTimeout)
                .until(ExpectedConditions.visibilityOf(notNowButton));
        notNowButton.click();
    }
}
