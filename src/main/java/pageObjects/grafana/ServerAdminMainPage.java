package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ServerAdminMainPage {

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    @FindBy(className = "css-1sara2j-button")
    public WebElement btn_newUser;

    @FindBy(className = "css-1wdli31-input-input")
    public WebElement txt_search;

}
