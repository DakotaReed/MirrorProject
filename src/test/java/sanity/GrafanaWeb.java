package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.ListenersAuto.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test 01: Log In + Verify Header")
    @Description("Log In + Verify Header")
    public void test01_verifyHeader() {
        WebFlows.login(getData("UserName"), getData("UserPass"));
        Verifications.verifyTextInElement(grafanaMain.headDashboard, "Welcome to Grafana");
    }
    @Test(description = "Test 02: Checking User/s in List")
    @Description("Checking User/s in List")
    public void test02_verifyDefaultUsers() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }
    @Test(description = "Test 03: Create New User")
    @Description("Create New User")
    public void test03_verifyNewUser() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.createNewUser("aaaa", "bbbb", "cccc");
        UIActions.click(grafanaUsersPage.link_headerUsers);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }
    @Test(description = "Test 04: Delete User")
    @Description("Delete User")
    public void test04_verifyUserDeletion() throws InterruptedException {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.deleteLastUser();
        Thread.sleep(1000);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }
    @Test(description = "Test 05: Checking Present of Dropdown Menu")
    @Description("Checking Present of Dropdown Menu")
    public void test05_verifyPresentOfDropMenu() {
        Verifications.presentOfTheObjects(grafanaMain.listHeaderPanels, grafanaMain.dropdownMenuOpen);
    }
    @Test(description = "Test 06: Verifying IconImage")
    @Description("Verifying IconImage using Sikuli tool")
    public void test06_verifyIconImage() {
        Verifications.visualImageElement("iconAdmin");
    }
    @Test(description = "Test 07: Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("Search Users in a Table using DDT")
    public void test07_verifySearchUsers(String user, String shouldExist) {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.searchAndVerifyUser(user, shouldExist);
    }

}
