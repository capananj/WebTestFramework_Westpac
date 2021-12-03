package westpac.suites.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import westpac.framework.excelReader.DataProviderUtil;
import westpac.suites.pageobjects.loginLogoutPageObject;
import westpac.suites.pageobjects.viewOverallRatingPageObject;
import westpac.suites.pages.loginLogoutPage;
import westpac.suites.pages.viewOverallRatingPage;

import java.util.HashMap;

public class viewOverallRatingTest extends DataProviderUtil {

    viewOverallRatingPageObject viewOverallRatingPO;
    viewOverallRatingPage viewOverallRatingPage;
    loginLogoutPageObject loginLogoutPO;
    loginLogoutPage loginLogoutPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }
    @Test(description = "View Car Overall Ratings Page", groups = "regression",  priority = 1, dataProvider = "getViewOverallRatings")
    public void viewOverallCarRatings(HashMap<String, String> data) {
        viewOverallRatingPage = new viewOverallRatingPage(data);
        viewOverallRatingPO = new viewOverallRatingPageObject();
        loginLogoutPage = new loginLogoutPage(data);
        loginLogoutPO = new loginLogoutPageObject();

        // User will login
        loginLogoutPage.login();

        //User will go to Overall Rating Page to view the number of votes and other information about the cars
        viewOverallRatingPage.goToOverallCarRatingsPage();
        viewOverallRatingPO.btnMake.isDisplayed();
        viewOverallRatingPO.btnModel.isDisplayed();
        viewOverallRatingPO.btnRank.isDisplayed();
        viewOverallRatingPO.btnVotes.isDisplayed();
        viewOverallRatingPO.btnEngine.isDisplayed();
        viewOverallRatingPO.txtComments.isDisplayed();

        // User will log out from the page
        loginLogoutPage.logout();

    }
}
