package westpac.suites.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import westpac.framework.WebDriverManager;

public class loginLogoutPageObject {

    @FindBy(xpath = "//a[contains(., 'Logout')]")
    @CacheLookup
    public WebElement btnLogout;

    @FindBy(xpath = "//button[contains(., 'Login')]")
    @CacheLookup
    public WebElement btnLogin;

    @FindBy(xpath = "//input[@name='login']")
    @CacheLookup
    public WebElement txtUserName;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    public WebElement txtPassword;

    @FindBy(xpath = "//span[@class='nav-link disabled']")
    @CacheLookup
    public WebElement txtFirstName;


    public loginLogoutPageObject() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}