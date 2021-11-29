package io.unity.autoweb;

import org.openqa.selenium.WebDriver;

public class Browser {
    WebDriver driver;
    FindElement element;

    public Browser(WebDriver dri) {
        this.driver = dri;
        element = new FindElement(driver);

    }


    public void open_url(String url) {
        driver.get(url);
    }


    public String get_current_url() {
        return driver.getCurrentUrl();
    }

    public String get_page_source() {
        return driver.getPageSource();
    }

    public String get_title() {
        return driver.getTitle();
    }

    public void navigate_to_back() {
         driver.navigate().back();
    }

    public void navigate_to_forward() {
        driver.navigate().forward();
    }

    public void refresh_page() {
        driver.navigate().refresh();
    }
    public void click(String elementName) {
        element.find(driver, elementName).click();
    }

    public void enter_text(String element_name, String text_to_enter) {
        element.find(driver, element_name).sendKeys(text_to_enter);
    }


}

