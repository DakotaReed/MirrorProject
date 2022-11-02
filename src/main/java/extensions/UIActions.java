package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {


    @Step("Click on element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Updating text")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Updating text as human")
    public static void updateTextAsHuman(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }
//    public static void updateDropdown(WebElement elem, String text) {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//        Select dropDown = new Select(elem);
//        dropDown.selectByVisibleText(text);
//    }

    @Step("Moving mouse to the element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
