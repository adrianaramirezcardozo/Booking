package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ZERO;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Helpers {
    public enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT,
    }
    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public void swipeVertically(AndroidDriver driver, Directions direction) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (direction) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipeVertically = new Sequence(FINGER, 0);
        swipeVertically.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipeVertically.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipeVertically.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), startX, endY));
        swipeVertically.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipeVertically));
    }

    public void swipeHorizontally(AndroidDriver driver, Directions direction) {
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
        int startX = (int) (driver.manage().window().getSize().getWidth() * 0.8);

        int endX;

        switch (direction) {
            case RIGHT -> endX = (int) (driver.manage().window().getSize().getWidth() * 0.8); // hacia la derecha
            case LEFT -> endX = (int) (driver.manage().window().getSize().getWidth() * 0.2);  // hacia la izquierda
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipeHorizontally = new Sequence(FINGER, 0);
        swipeHorizontally.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipeHorizontally.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipeHorizontally.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), endX, startY));
        swipeHorizontally.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipeHorizontally));
    }

    public void swipeHorizontallyMultipleTimes(AndroidDriver driver, Directions direction, int times) {
        for (int i = 0; i < times; i++) {
            swipeHorizontally(driver, direction);
            try { Thread.sleep(400); } catch (InterruptedException e) {} // opcional: espera entre gestos
        }
    }
    public void tapAtCoordinates(AndroidDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }
    public void scrollToElementWithText(AndroidDriver driver, String text) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()"
                + ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))"));
    }





}
