package io.unity.autoweb;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {

    WebDriver driver;

    public FindElement(WebDriver dri) {
        this.driver = dri;
    }

    public WebElement find(WebDriver driver, String locator_value) {

        WebElement element = null;
        String[] locator_to_find = locator_value.split(":");

        System.out.println(locator_to_find);
        System.out.println(locator_to_find[1]);
        if (locator_value.contains("xpath")) {
            element = driver.findElement(By.xpath(locator_to_find[1]));
        }
        return element;
    }


}
