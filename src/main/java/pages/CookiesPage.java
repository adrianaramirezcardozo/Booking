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


public class CookiesPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "bt_accept")
    private RemoteWebElement acceptCookiesButton;

    public CookiesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Accept Cookies")
    public void acceptCookies() {
        new WebDriverWait(driver, GlobalVariables.longTimeout)
                .until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        acceptCookiesButton.click();
    }
}