package westpac.suites.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import westpac.framework.excelReader.DataProviderUtil;
import westpac.suites.pageobjects.loginLogoutPageObject;
import westpac.suites.pageobjects.registerPageObject;
import westpac.suites.pageobjects.voteCarRatingsPageObject;
import westpac.suites.pages.loginLogoutPage;
import westpac.suites.pages.registerPage;
import westpac.suites.pages.voteCarRatingsPage;

import java.util.HashMap;

public class voteCarRatingsTest extends DataProviderUtil {

    voteCarRatingsPageObject voteCarRatingsPO;
    voteCarRatingsPage voteCarRatingsPage;
    loginLogoutPage loginLogoutPage;
    loginLogoutPageObject loginLogoutPO;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }

    @Test(description = "Vote for Car Ratings", groups = "regression",  priority = 1, dataProvider = "getVoteCarRatings")
    public void voteCarRatings(HashMap<String, String> data) {
        voteCarRatingsPage = new voteCarRatingsPage(data);
        voteCarRatingsPO = new voteCarRatingsPageObject();
        loginLogoutPage = new loginLogoutPage(data);
        loginLogoutPO = new loginLogoutPageObject();

        // User creates new registration then logins
        loginLogoutPage.newUserRegistrationAndLogin();

        // User will vote for a car
        voteCarRatingsPage.voteForCarRatings();
        Assert.assertEquals(voteCarRatingsPO.txtSuccessfulVoteDisplay.getText(), "Thank you for your vote!");

    }
}
