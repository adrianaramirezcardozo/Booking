package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ITestListenerUtility.class})
public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;
    private final AppiumServerManager appiumServerManager = new AppiumServerManager();

    protected Helpers helpers;

    protected CookiesPage cookiesPage;
    protected SignInPage signInPage;
    protected NotificationsPage notificationsPage;
    protected HomePage homePage;
    protected SearchPage searchPage;
    protected SavedPage savedPage;

    @Step("Starting Android driver")
    @BeforeSuite
    public void startAppiumServer() {
        appiumServerManager.startAppiumServerWithCustomFlags();
    }

    @BeforeMethod
    public void setUp() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setAvd(getProperty("avd"))
                .setApp(getProperty("app"))
                .setAppPackage(getProperty("app.package"))
                .setNoReset(false)
                .setFullReset(true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.appiumLocalUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        helpers = new Helpers();

        cookiesPage = new CookiesPage(driver);
        signInPage = new SignInPage(driver);
        notificationsPage = new NotificationsPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        savedPage = new SavedPage(driver);
    }

    @Step("Stopping Android driver")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        appiumServerManager.stopAppiumServer();
    }
}
