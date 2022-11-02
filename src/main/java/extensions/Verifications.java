package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;


public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Number Of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Present Of The Objects (SoftAssertion)")
    public static void presentOfTheObjects(List<WebElement> elems, WebElement elementToView) {
        for (WebElement elem : elems) {
            UIActions.click(elem);
            softAssert.assertTrue(elementToView.isDisplayed(), "Element is not Displayed");
        }
        softAssert.assertAll("Some of Elements is not Displayed");
    }

    @Step("Verify Image Element Visually")
    public static void visualImageElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error comparing Image File: " + e);
            fail("Error comparing Image File: " + e);
        }
    }

    @Step("Existence of Element")
    public static void existenceOfElement(List<WebElement> elements) {
        assertTrue(elements.size()>0);
    }

    @Step("NOT Existence of Element")
    public static void notExistenceOfElement(List<WebElement> elements) {
        assertFalse(elements.size()>0);
    }
}
