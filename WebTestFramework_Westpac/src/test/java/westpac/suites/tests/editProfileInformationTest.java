package westpac.suites.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import westpac.framework.excelReader.DataProviderUtil;
import westpac.suites.pageobjects.editProfileInformationPageObject;
import westpac.suites.pageobjects.loginLogoutPageObject;
import westpac.suites.pages.editProfileInformationPage;
import westpac.suites.pages.loginLogoutPage;

import java.util.HashMap;

public class editProfileInformationTest extends DataProviderUtil {

    editProfileInformationPageObject editProfileInformationPO;
    editProfileInformationPage editProfileInformationPage;
    loginLogoutPage loginLogoutPage;
    loginLogoutPageObject loginLogoutPO;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }

    @Test(description = "Edit User Profile", groups = "regression",  priority = 1, dataProvider = "getEditProfileInformation")
    public void editProfileInformation(HashMap<String, String> data){
        editProfileInformationPage = new editProfileInformationPage(data);
        editProfileInformationPO = new editProfileInformationPageObject();
        loginLogoutPage = new loginLogoutPage(data);
        loginLogoutPO = new loginLogoutPageObject();

        // User will login
        loginLogoutPage.login();

        // User will edit his profile information
        editProfileInformationPage.editUserProfile();
        Assert.assertEquals(editProfileInformationPO.txtProfileSaveSuccessfullyMessageDisplay.getText(), "The profile has been saved successful");

        // User will log out from the page
        loginLogoutPage.logout();
    }
}
