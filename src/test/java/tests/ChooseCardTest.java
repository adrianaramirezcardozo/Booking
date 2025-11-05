package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Choose Card epic")
@Feature("Choose Card feature")
public class ChooseCardTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Choose a card from list")
    @Story("Successful choosing a card from list")
    @Test(testName = "Choose Card test")
    public void chooseCardTest() {
        //Start the Booking application and continue without sign in.
        cookiesPage.acceptCookies();
        notificationsPage.setNotificationsLater();
        signInPage.continueWithoutLogin();

        //Deal with any popups that show up on the application
        Assert.assertTrue(homePage.signInPopUpIsDisplayed(), "Login popup is not displayed");
        homePage.ignorePopUp();
        Assert.assertTrue(homePage.signInPopUpIsNotDisplayed(), "Login popup is displayed");

        //On search page, scroll down to Need ideas? and validate at least 1 country card is shown
        homePage.navigateToBottom();
        Assert.assertTrue(homePage.needIdeasSectionIsDisplayed(), "Need ideas section is not displayed");

        //Scroll and click on the 4th card in row
        homePage.navigateToFourthCard();
        homePage.openFourthCard();

        //Validate user is taken to the search results screen and town from the card is the one being searched
        Assert.assertTrue(searchPage.searchFieldTextIs("Granada"), "Correct Title is not displayed");

        //Click sort by and select any filter
        searchPage.clickSortButton();
        searchPage.chooseDistanceFromDowntown();

    }
}