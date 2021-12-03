package westpac.suites.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import westpac.framework.ConfigLoader;
import westpac.framework.WebDriverActions;
import westpac.suites.pageobjects.registerPageObject;

import java.util.HashMap;
import java.util.Random;

public class registerPage extends WebDriverActions {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public registerPageObject registerPO;
    HashMap<String, String> data;


    public registerPage(HashMap<String, String> data){
        this.data = data;
        registerPO = new registerPageObject();

    }

    public void newUserRegistration(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        click(registerPO.btnRegisterPage);
        registerPO.txtUsername.sendKeys(data.get("userName")+ randomInt +"@sample.com");
        enterText(registerPO.txtFirstname, data.get("firstName"));
        enterText(registerPO.txtLastname, data.get("lastName"));
        enterText(registerPO.txtPassword, data.get("password"));
        enterText(registerPO.txtConfirmPassword, data.get("confirmPassword"));
        click(registerPO.btnRegister);
        waitFor().until(ExpectedConditions.visibilityOf(registerPO.txtSuccessfulRegistrationMessageDisplay));
        registerPO.txtUsername.getText();
    }


}
