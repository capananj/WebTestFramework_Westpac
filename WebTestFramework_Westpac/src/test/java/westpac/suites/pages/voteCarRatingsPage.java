package westpac.suites.pages;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import westpac.framework.ConfigLoader;
import westpac.framework.WebDriverActions;
import westpac.suites.pageobjects.voteCarRatingsPageObject;

import java.util.HashMap;
import java.util.Random;

public class voteCarRatingsPage extends WebDriverActions {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public voteCarRatingsPageObject voteCarRatingsPO;
    HashMap<String, String> data;

    public voteCarRatingsPage(HashMap<String, String> data) {
        this.data = data;
        voteCarRatingsPO = new voteCarRatingsPageObject();
    }

    public void voteForCarRatings() {

        click(voteCarRatingsPO.lnkBuggyCarRatingsHomepage);
        waitFor().until(ExpectedConditions.visibilityOf(voteCarRatingsPO.lnkPopularMake));
        click(voteCarRatingsPO.lnkPopularMake);
        waitFor().until(ExpectedConditions.visibilityOf(voteCarRatingsPO.lnkCar));
        click(voteCarRatingsPO.lnkCar);
        waitFor().until(ExpectedConditions.visibilityOf(voteCarRatingsPO.txtComment));
        Integer vote = Integer.parseInt(voteCarRatingsPO.txtVoteResults.getText()) + 1;

        enterText(voteCarRatingsPO.txtComment, data.get("userComment"));
        click(voteCarRatingsPO.btnVote);
        waitFor().until(ExpectedConditions.visibilityOf(voteCarRatingsPO.txtSuccessfulVoteDisplay));
        Assert.assertEquals(voteCarRatingsPO.txtVoteResults.getText(), String.valueOf(vote));
    }

 }
