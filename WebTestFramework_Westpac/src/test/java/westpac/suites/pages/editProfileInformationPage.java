package westpac.suites.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import westpac.framework.ConfigLoader;
import westpac.framework.WebDriverActions;

import westpac.suites.pageobjects.editProfileInformationPageObject;

import java.util.HashMap;

public class editProfileInformationPage extends WebDriverActions {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public editProfileInformationPageObject editProfileInformationPO;
    HashMap<String, String> data;

    public editProfileInformationPage(HashMap<String, String> data) {
        this.data = data;
        editProfileInformationPO = new editProfileInformationPageObject();
    }

    public void editUserProfile() {
        click(editProfileInformationPO.lnkProfilePage);
        enterText(editProfileInformationPO.drpdwnGender, data.get("gender"));
        enterText(editProfileInformationPO.txtAge, data.get("age"));
        enterText(editProfileInformationPO.txtAddress, data.get("address"));
        enterText(editProfileInformationPO.txtPhone, data.get("phone"));
        selectDropdown(editProfileInformationPO.drpdwnHobby, data.get("hobby"));
        click(editProfileInformationPO.btnSave);
        waitFor().until(ExpectedConditions.visibilityOf(editProfileInformationPO.txtProfileSaveSuccessfullyMessageDisplay));

    }


 }
