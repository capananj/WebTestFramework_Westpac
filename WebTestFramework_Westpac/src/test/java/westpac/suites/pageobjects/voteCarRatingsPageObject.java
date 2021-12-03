package westpac.suites.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import westpac.framework.WebDriverManager;

public class voteCarRatingsPageObject {

    @FindBy(xpath = "//div[@class='container']/a[contains(., 'Buggy Rating')]")
    @CacheLookup
    public WebElement lnkBuggyCarRatingsHomepage;

    @FindBy(xpath = "//div[@class='col-md-4']/div/a/img[@title='Lamborghini']")
    @CacheLookup
    public WebElement lnkPopularMake;

    @FindBy(xpath = "//div[@class='row']/table/tbody/tr/td/a[contains(., 'Diablo')]")
    @CacheLookup
    public WebElement lnkCar;

    @FindBy(id = "comment")
    @CacheLookup
    public WebElement txtComment;

    @FindBy(xpath = "//div[@class='col-lg-4']/div/div/div/button[contains(., 'Vote!')]")
    @CacheLookup
    public WebElement btnVote;

    @FindBy(xpath = "//div[@class='col-lg-4']/div/div/p[contains(., 'Thank you for your vote!')]")
    @CacheLookup
    public WebElement txtSuccessfulVoteDisplay;

    @FindBy(xpath = "//h4/strong")
    @CacheLookup
    public WebElement txtVoteResults;

    public voteCarRatingsPageObject(){
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }


}