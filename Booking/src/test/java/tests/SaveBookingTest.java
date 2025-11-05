package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Save Booking epic")
@Feature("Save Booking  feature")
public class SaveBookingTest extends DriverSetup {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that the booking is saved")
    @Story("Successful booking saved")
    @Test(testName = "Save Booking test")
    public void saveBookingTest() {
        //Start the Booking application and continue without sign in.
        cookiesPage.acceptCookies();
        notificationsPage.setNotificationsLater();
        signInPage.continueWithoutLogin();

        //Deal with any popups that show up on the application
        Assert.assertTrue(homePage.signInPopUpIsDisplayed(), "Login popup is not displayed");
        homePage.ignorePopUp();
        Assert.assertTrue(homePage.signInPopUpIsNotDisplayed(), "Login popup is displayed");

        //Select Skopje as destination
        homePage.openDestination();
        searchPage.enterDestination("Skopje");
        searchPage.openFirstCity();

        //Select {date} as date
        Assert.assertTrue(searchPage.calendarMonthList(), "Calendar month list is not displayed");
        searchPage.confirmDates();

        //Select 2 rooms and 3 adults
        searchPage.openRoomAndGuestsField();
        searchPage.addRoom();
        searchPage.addAdult();
        searchPage.confirmRoomsAndGuests();

        //Click Search
        searchPage.searchBooking();

        //Click on Save button (heart) on one of the listed properties
        searchPage.addToWhishlist();

        //Go back to the search page
        searchPage.navigateUp();

        //Click on Saved tab
        homePage.openSavedBookingTab();

        //Validate property is shown in Saved tab
        Assert.assertTrue(savedPage.myNextTripTitleIsDisplayed(), "My Next Trip title is not displayed");
    }
}