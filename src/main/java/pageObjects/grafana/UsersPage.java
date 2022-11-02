package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

    @FindBy(linkText = "Users")
    public WebElement link_headerUsers;

    @FindBy(className = "css-mk7eo3-button")
    public WebElement btn_deleteUser;

    @FindBy(css = "button[aria-label='Confirm Modal Danger Button']")
    public WebElement btn_confirmDeletingUser;

}
