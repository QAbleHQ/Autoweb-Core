package io.unity.autoweb;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Element {

    WebDriver driver;

    public Element(WebDriver dri) {
        this.driver = dri;
    }


    public WebElement find(String locator_value) {


        WebElement element = null;
        locator_reader reader = new locator_reader();

        String[] locator_to_find = reader.get_locator_value(locator_value).split(":");

        System.out.println("Finding Element Using : " +locator_to_find[0]);
        System.out.println("Trying to find Element : "  + locator_to_find[1]);
        switch (locator_to_find[0]) {
            case "xpath":
                element = driver.findElement(By.xpath(locator_to_find[1]));
                break;
            case "id":
                element = driver.findElement(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                element = driver.findElement(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                element = driver.findElement(By.className(locator_to_find[1]));
                break;
            case "name":
                element = driver.findElement(By.name(locator_to_find[1]));
                break;
            case "link_text":
                element = driver.findElement(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                element = driver.findElement(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                element = driver.findElement(By.tagName(locator_to_find[1]));
                break;
            default:
                System.err.println("Incorrect Locator Type");
        }

        return element;
    }


    public List<WebElement> find_multiple_elements(String locator_value) {

        List<WebElement> elements = null;
        String[] locator_to_find = locator_value.split(":");

        switch (locator_to_find[0]) {
            case "xpath":
                elements = driver.findElements(By.xpath(locator_to_find[1]));
                break;
            case "id":
                elements = driver.findElements(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                elements = driver.findElements(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                elements = driver.findElements(By.className(locator_to_find[1]));
                break;
            case "name":
                elements = driver.findElements(By.name(locator_to_find[1]));
                break;
            case "link_text":
                elements = driver.findElements(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                elements = driver.findElements(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                elements = driver.findElements(By.tagName(locator_to_find[1]));
                break;
            default:
                System.err.println("Incorrect Locator Type");
        }

        return elements;
    }


    public List<WebElement> find_multiple_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        List<WebElement> elements = null;
        String[] locator_to_find = element_to_find.split(":");

        switch (locator_to_find[0]) {
            case "xpath":
                elements = main.findElements(By.xpath(locator_to_find[1]));
                break;
            case "id":
                elements = main.findElements(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                elements = main.findElements(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                elements = main.findElements(By.className(locator_to_find[1]));
                break;
            case "name":
                elements = main.findElements(By.name(locator_to_find[1]));
                break;
            case "link_text":
                elements = main.findElements(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                elements = main.findElements(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                elements = main.findElements(By.tagName(locator_to_find[1]));
                break;
            default:
                System.err.println("Incorrect Locator Type");
        }


        return elements;
    }


    public WebElement find_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        WebElement element = null;
        String[] locator_to_find = element_to_find.split(":");

        switch (locator_to_find[0]) {
            case "xpath":
                element = main.findElement(By.xpath(locator_to_find[1]));
                break;
            case "id":
                element = main.findElement(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                element = main.findElement(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                element = main.findElement(By.className(locator_to_find[1]));
                break;
            case "name":
                element = main.findElement(By.name(locator_to_find[1]));
                break;
            case "link_text":
                element = main.findElement(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                element = main.findElement(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                element = main.findElement(By.tagName(locator_to_find[1]));
                break;
            default:
                System.err.println("Incorrect Locator Type");
        }

        return element;
    }

    public WebElement get_active_element() {
        return driver.switchTo().activeElement();
    }

    public String get_element_tag(String locator_value) {
        return find(locator_value).getTagName();
    }

    public String get_css_value(String locator_value, String css) {
        return find(locator_value).getCssValue(css);
    }

    public String get_element_text(String locator_value) {
        return find(locator_value).getText();
    }

    public void find_above_element(String locator_value) {


    }

    public void find_below_element(String locator_value) {


    }


    public void enter_text(String locator_value, String text_to_enter) {
        find(locator_value).sendKeys(text_to_enter);
    }

    public void clear_text_field(String locator_value, String text_to_enter) {
        find(locator_value).sendKeys(text_to_enter);
    }

    public void clear_and_enter_in_text_field(String locator_value, String text_to_enter)
    {
        find(locator_value).clear();
        find(locator_value).sendKeys(text_to_enter);
    }

    public void click(String locator_value)
    {
        find(locator_value).click();
    }
}
