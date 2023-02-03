package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grafana.*;
import pageObjects.mortgageCalc.MainPage;

public class Base {

    //----General----
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;

    //----Web----
    protected static WebDriver driver;

    //----Mobile----
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc;
    protected static TouchAction touchAction;

    //----Rest API----
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;

    //----Page Objects - Web----
    protected static pageObjects.grafana.LoginPage grafanaLogin;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static LeftMenuPage grafanaLeftMenu;
    protected static ServerAdminMenuPage grafanaServerAdminMenu;
    protected static ServerAdminMainPage grafanaServerAdminMain;
    protected static AddNewUserPage grafanaAddNewUser;
    protected static UsersPage grafanaUsersPage;

    //----Page Objects - Mobile----
    protected static MainPage mortgageCalculator;

}
