package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty(String jPath) {
        response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Team")
    public static void postTeam(String name, String email) {
        params = new JSONObject();
        params.put("name", name);
        params.put("email", email);
        ApiActions.post(params, "/api/teams");
    }

    @Step("Business Flow: Update Team")
    public static void putTeam(String name, String email, String id) {
        params = new JSONObject();
        params.put("name", name);
        params.put("email", email);
        ApiActions.put(params, "/api/teams/" + id);
    }

    @Step("Business Flow: Delete Team")
    public static void deleteTeam(String id) {
        ApiActions.delete(id);
    }

}
