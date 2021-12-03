package westpac.suites.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import westpac.framework.ConfigLoader;
import westpac.framework.WebDriverActions;
import westpac.suites.pageobjects.loginLogoutPageObject;
import westpac.suites.pageobjects.registerPageObject;

import java.util.HashMap;
import java.util.Random;

public class loginLogoutPage extends WebDriverActions {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public loginLogoutPageObject loginLogoutPO;
    public registerPageObject registerPO;
    HashMap<String, String> data;

    public loginLogoutPage(HashMap<String, String> data) {
        this.data = data;
        loginLogoutPO = new loginLogoutPageObject();
        registerPO = new registerPageObject();
    }

    public void login() {
        enterText(loginLogoutPO.txtUserName, data.get("userName"));
        enterText(loginLogoutPO.txtPassword, data.get("password"));
        click(loginLogoutPO.btnLogin);
        waitFor().until(ExpectedConditions.visibilityOf(loginLogoutPO.txtFirstName));
    }

    public void logout() {
        click(loginLogoutPO.btnLogout);
    }

    public void newUserRegistrationAndLogin() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);


        click(registerPO.btnRegisterPage);
        registerPO.txtUsername.sendKeys(data.get("userName")+ randomInt +"@sample.com");
        String val = registerPO.txtUsername.getAttribute("value");
        enterText(registerPO.txtFirstname, data.get("firstName"));
        enterText(registerPO.txtLastname, data.get("lastName"));
        enterText(registerPO.txtPassword, data.get("password"));
        enterText(registerPO.txtConfirmPassword, data.get("confirmPassword"));
        click(registerPO.btnRegister);
        waitFor().until(ExpectedConditions.visibilityOf(registerPO.txtSuccessfulRegistrationMessageDisplay));
        registerPO.txtUsername.getText();
        enterText(loginLogoutPO.txtUserName, val);
        enterText(loginLogoutPO.txtPassword, data.get("password"));
        click(loginLogoutPO.btnLogin);
        waitFor().until(ExpectedConditions.visibilityOf(loginLogoutPO.txtFirstName));
    }

 }
