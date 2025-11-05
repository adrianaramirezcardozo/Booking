package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
public class SignInPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private RemoteWebElement continueWithoutLoginButton;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Continue without login")
    public void continueWithoutLogin() {
        continueWithoutLoginButton.click();
    }
}
