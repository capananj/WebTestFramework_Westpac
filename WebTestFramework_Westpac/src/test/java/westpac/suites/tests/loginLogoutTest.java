package westpac.suites.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import westpac.framework.excelReader.DataProviderUtil;

import westpac.suites.pageobjects.loginLogoutPageObject;
import westpac.suites.pages.loginLogoutPage;

import java.util.HashMap;

public class loginLogoutTest extends DataProviderUtil {

    loginLogoutPage loginLogoutPage;
    loginLogoutPageObject loginLogoutPO;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }
    @Test(description = "User Login", groups = "regression",  priority = 1, dataProvider = "getLogin")
    public void loginLogOut (HashMap<String, String> data) {
        loginLogoutPage = new loginLogoutPage(data);
        loginLogoutPO = new loginLogoutPageObject();

        // User will login
        loginLogoutPage.login();
        Assert.assertEquals(loginLogoutPO.txtFirstName.getText(), "Hi, " + data.get("firstName"));

        // User will log out from the page
        loginLogoutPage.logout();
        loginLogoutPO.btnLogin.isEnabled();
    }
}
