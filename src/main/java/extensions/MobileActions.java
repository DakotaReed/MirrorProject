package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;

public class MobileActions extends CommonOps {

    @Step("Tap on Element")
    public static void tap(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        touchAction.tap(new TapOptions().withElement(ElementOption.element(element))).perform();
    }

    @Step("Updating text")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = mobileDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    @Step("Zoom element")
    public static void zoom(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction<>(mobileDriver);
        finger1.press(new ElementOption().withElement(element).withCoordinates(x, y - 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 100));
        TouchAction finger2 = new TouchAction<>(mobileDriver);
        finger2.press(new ElementOption().withElement(element).withCoordinates(x, y + 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 100));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    @Step("Pinch element")
    public static void pinch(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction<>(mobileDriver);
        finger1.press(new ElementOption().withElement(element).withCoordinates(x, y - 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 10));
        TouchAction finger2 = new TouchAction<>(mobileDriver);
        finger2.press(new ElementOption().withElement(element).withCoordinates(x, y + 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 10));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

}
