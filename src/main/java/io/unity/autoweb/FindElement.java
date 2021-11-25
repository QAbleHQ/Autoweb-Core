package io.unity.autoweb;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {

    public WebElement find(WebDriver driver, JSONObject object) {

        String locator_type = object.get("locator_type").toString();
        String locator_value = object.get("locator_value").toString();
        WebElement element = null;
        if (locator_type.equalsIgnoreCase("xpath")) {
            element = driver.findElement(By.xpath(locator_value));
        }
        return element;
    }


}
