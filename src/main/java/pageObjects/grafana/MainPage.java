package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainPage {

    @FindBy(className = "css-oi140o")
    public WebElement headDashboard;

    @FindBy(css = "header[class='panel-title-container']")
    public List<WebElement> listHeaderPanels;

    @FindBy(css = "div[class='panel-menu-container dropdown open']")
    public WebElement dropdownMenuOpen;

}
