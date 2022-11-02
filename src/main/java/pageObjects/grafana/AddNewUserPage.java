package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage {

    @FindBy(id = "name-input")
    public WebElement txt_name;

    @FindBy(id = "password-input")
    public WebElement txt_password;

    @FindBy(id = "username-input")
    public WebElement txt_userName;

    @FindBy(className = "css-1sara2j-button")
    public WebElement btn_createUser;

}
