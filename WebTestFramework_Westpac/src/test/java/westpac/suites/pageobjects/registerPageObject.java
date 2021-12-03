package westpac.suites.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import westpac.framework.WebDriverManager;

public class registerPageObject {

    @FindBy(xpath = "//a[contains(., 'Register')]")
    @CacheLookup
    public WebElement btnRegisterPage;

    @FindBy(id = "username")
    @CacheLookup
    public WebElement txtUsername;

    @FindBy(id = "firstName")
    @CacheLookup
    public WebElement txtFirstname;

    @FindBy(id = "lastName")
    @CacheLookup
    public WebElement txtLastname;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement txtPassword;

    @FindBy(id = "confirmPassword")
    @CacheLookup
    public WebElement txtConfirmPassword;

    @FindBy(xpath = "//button[contains(., 'Register')]")
    @CacheLookup
    public WebElement btnRegister;

    @FindBy(xpath = "//div[@class='col-md-6']/form/div[contains(., 'Registration is successful')]")
    @CacheLookup
    public WebElement txtSuccessfulRegistrationMessageDisplay;


    public registerPageObject() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}