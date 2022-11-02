package workflows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String user, String password) {
        UIActions.updateText(grafanaLogin.txt_user, user);
        UIActions.updateText(grafanaLogin.txt_password, password);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Creating new user")
    public static void createNewUser(String name, String username, String pass) {
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_userName, username);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.click(grafanaAddNewUser.btn_createUser);
    }

    @Step("Business Flow: Deleting last user")
    public static void deleteLastUser() {
        wait.until(ExpectedConditions.elementToBeClickable(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1)));
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1).findElement(By.tagName("a")));
        UIActions.click(grafanaUsersPage.btn_deleteUser);
        UIActions.click(grafanaUsersPage.btn_confirmDeletingUser);
    }

    @Step("Search and Verify User")
    public static void searchAndVerifyUser(String user, String shouldExists) {
        UIActions.updateTextAsHuman(grafanaServerAdminMain.txt_search, user);
        if (shouldExists.equalsIgnoreCase("exist"))
            Verifications.existenceOfElement(grafanaServerAdminMain.rows);
        else if (shouldExists.equalsIgnoreCase("not-exist"))
            Verifications.notExistenceOfElement(grafanaServerAdminMain.rows);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven Testing");
    }
}
