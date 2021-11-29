package io.unity.autoweb;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FindElement {

    WebDriver driver;

    public FindElement(WebDriver dri) {
        this.driver = dri;
    }

    public WebElement find(String locator_value) {

        WebElement element = null;
        String[] locator_to_find = locator_value.split(":");

        switch(locator_to_find[0]) {
            case "xpath":
                element = driver.findElement(By.xpath(locator_to_find[1]));
            case "id" :
                element = driver.findElement(By.id(locator_to_find[1]));
            case "css_selector" :
                element = driver.findElement(By.cssSelector(locator_to_find[1]));
            case "class_name" :
                element = driver.findElement(By.className(locator_to_find[1]));
            case "name" :
                element = driver.findElement(By.name(locator_to_find[1]));
            case "link_text" :
                element = driver.findElement(By.linkText(locator_to_find[1]));
            case "partial_link_text" :
                element = driver.findElement(By.partialLinkText(locator_to_find[1]));
            case "tag" :
                element = driver.findElement(By.tagName(locator_to_find[1]));
            default:
                System.err.println("Incorrect Locator Type");
        }

        return element;
    }

    public void find_above_element(String locator_value)
    {


    }

    public void find_below_element(String locator_value)
    {


    }



}
