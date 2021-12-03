package westpac.suites.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import westpac.framework.WebDriverManager;

public class viewOverallRatingPageObject {
    @FindBy (xpath = "//a[@href='/overall']")
    @CacheLookup
    public WebElement btnOverallRatingPage;

    @FindBy(xpath = "//a[contains(., 'Make')]")
    @CacheLookup
    public WebElement btnMake;

    @FindBy(xpath = "//a[contains(., 'Model')]")
    @CacheLookup
    public WebElement btnModel;

    @FindBy(xpath = "//a[contains(., 'Rank')]")
    @CacheLookup
    public WebElement btnRank;

    @FindBy(xpath = "//a[contains(., 'Votes')]")
    @CacheLookup
    public WebElement btnVotes;

    @FindBy(xpath = "//a[contains(., 'Engine')]")
    @CacheLookup
    public WebElement btnEngine;

    @FindBy(xpath = "//th[contains(., 'Comments')]")
    @CacheLookup
    public WebElement txtComments;

    public viewOverallRatingPageObject() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}