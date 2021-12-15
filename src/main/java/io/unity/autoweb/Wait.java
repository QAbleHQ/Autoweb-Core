package io.unity.autoweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    WebDriver driver;
    Element element;

    public Wait(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

    }

    public void wait_until_element_is_clickable(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(element.find(locator_value)));
    }


    public void wait_until_element_is_visible(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOf((element.find(locator_value))));
    }

    public void wait_until_element_is_disappear(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOf((element.find(locator_value))));
    }

    public void wait_until_all_element_is_visible(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfAllElements((element.find(locator_value))));
    }

    public void wait_until_all_element_is_disappear(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOfAllElements((element.find(locator_value))));
    }

    public void wait_until_alert_is_present() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void wait_for_second(int second) {
        try {
            Thread.sleep((long)second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
