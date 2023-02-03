package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.ListenersAuto.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: Verify Team")
    @Description("Verify Team Property")
    public static void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Kuku");
    }

    @Test(description = "Test 02: Add Team and Verify")
    @Description("Add Team and Verify Adding")
    public static void test02_addTeamAndVerify() {
        ApiFlows.postTeam("YoniTeam", "yoni@team.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "YoniTeam");
    }

    @Test(description = "Test 03: Update Team and Verify")
    @Description("Update Team and Verify Updating")
    public static void test03_updateTeamAndVerify() {
        ApiFlows.putTeam("YoniTeam", "yoni@atidcollege.co.il", ApiFlows.getTeamProperty("teams[1].id"));
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "yoni@atidcollege.co.il");
    }

    @Test(description = "Test 04: Delete Team and Verify")
    @Description("Delete Team and Verify Deleting")
    public static void test04_deleteTeamAndVerify() {
        ApiFlows.deleteTeam(ApiFlows.getTeamProperty("teams[1].id"));
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }

}
