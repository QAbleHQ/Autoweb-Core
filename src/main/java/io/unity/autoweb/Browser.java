package io.unity.autoweb;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class Browser {
    WebDriver driver;
    LocatorReader reader = new LocatorReader();
    FindElement element = new FindElement();

    public Browser(WebDriver dri) {
        this.driver = dri;
    }


    public void openURL(String url) {
        driver.get(url);
    }

    public void clickOn(String elementName)
    {
        JSONObject object = reader.getLocatorObject(elementName);
        element.find(driver,object).click();;
    }




}

