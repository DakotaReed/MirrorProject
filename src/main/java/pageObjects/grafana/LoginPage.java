package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "user")
    public WebElement txt_user;
    @FindBy(id = "current-password")
    public WebElement txt_password;
    @FindBy(className = "css-14g7ilz-button")
    public WebElement btn_login;
    @FindBy(className = "css-1kf0ycc-button")
    public WebElement btn_skip;

}
