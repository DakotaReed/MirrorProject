package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(xpath = "//ul[@class='css-kmtjxr']/li[7]")
    public WebElement btn_server;

}
