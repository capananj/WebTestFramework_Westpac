package westpac.suites.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import westpac.framework.WebDriverManager;

public class editProfileInformationPageObject {

    @FindBy(partialLinkText = "Profile")
    @CacheLookup
    public WebElement lnkProfilePage;

    @FindBy(id = "firstName")
    @CacheLookup
    public WebElement txtFirstName;

    @FindBy(id = "lastName")
    @CacheLookup
    public WebElement txtLastName;

    @FindBy(id = "gender")
    @CacheLookup
    public WebElement drpdwnGender;

    @FindBy(id = "age")
    @CacheLookup
    public WebElement txtAge;

    @FindBy(id = "address")
    @CacheLookup
    public WebElement txtAddress;

    @FindBy(id = "phone")
    @CacheLookup
    public WebElement txtPhone;

    @FindBy(id = "hobby")
    @CacheLookup
    public WebElement drpdwnHobby;

    @FindBy(xpath = "//button[contains(., 'Save')]")
    @CacheLookup
    public WebElement btnSave;

    @FindBy (xpath = "//div[@class='col-lg-4']/div[contains(., 'The profile has been saved successful')]")
    @CacheLookup
    public WebElement txtProfileSaveSuccessfullyMessageDisplay;

    public editProfileInformationPageObject(){
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }


}