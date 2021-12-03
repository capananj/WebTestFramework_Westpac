package westpac.suites.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import westpac.framework.ConfigLoader;
import westpac.framework.WebDriverActions;
import westpac.suites.pageobjects.viewOverallRatingPageObject;

import java.util.HashMap;

public class viewOverallRatingPage extends WebDriverActions {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public viewOverallRatingPageObject viewOverallRatingPO;
    HashMap<String, String> data;

    public viewOverallRatingPage(HashMap<String, String> data) {
        this.data = data;
        viewOverallRatingPO = new viewOverallRatingPageObject();
    }

    public void goToOverallCarRatingsPage() {
        click(viewOverallRatingPO.btnOverallRatingPage);
        waitFor().until(ExpectedConditions.visibilityOf(viewOverallRatingPO.btnVotes));

    }



 }
