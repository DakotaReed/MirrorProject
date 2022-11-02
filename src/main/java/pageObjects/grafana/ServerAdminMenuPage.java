package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMenuPage {

    @FindBy(xpath = "//a[@href='/admin/users']")
    public WebElement link_users;

}
