package westpac.suites.tests;

import org.testng.Assert;
import westpac.framework.excelReader.DataProviderUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import westpac.suites.pageobjects.registerPageObject;
import westpac.suites.pages.registerPage;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class registerTest extends DataProviderUtil {

    registerPageObject registerPO;
    registerPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }

    @Test(description = "New Registration", groups = "regression",  priority = 1, dataProvider = "getRegister")
    public void register (HashMap<String, String> data) {
        registerPage = new registerPage(data);
        registerPO = new registerPageObject();

        // User creates new registration
        registerPage.newUserRegistration();
        Assert.assertEquals(registerPO.txtSuccessfulRegistrationMessageDisplay.getText(), "Registration is successful");
    }
}
