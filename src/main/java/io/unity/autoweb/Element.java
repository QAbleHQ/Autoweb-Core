package io.unity.autoweb;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Element {

    WebDriver driver;
    testng_logs logs = new testng_logs();

    public Element(WebDriver dri) {
        this.driver = dri;
    }


    public WebElement find(String locator_value) {


        WebElement element = null;
        locator_reader reader = new locator_reader();

        String[] locator_to_find = reader.get_locator_value(locator_value).split(":");

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

        locator_reader reader = new locator_reader();
        String[] locator_to_find = reader.get_locator_value(locator_value).split(":");

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

        locator_reader reader = new locator_reader();
        String[] locator_to_find = reader.get_locator_value(element_to_find).split(":");

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

    public void enter_text(String locator_value, String text_to_enter) {
        logs.test_step("Enter text " + text_to_enter + " at locator " + locator_value);
        find(locator_value).sendKeys(text_to_enter);
    }

    public void clear_text_field(String locator_value) {
        logs.test_step("clear value from " + locator_value + " text fields");
        find(locator_value).clear();
    }

    public void clear_and_enter_in_text_field(String locator_value, String text_to_enter) {
        logs.test_step("clear value from " + locator_value + " text fields and enter text " + text_to_enter);
        find(locator_value).clear();
        find(locator_value).sendKeys(text_to_enter);
    }

    public void click(String locator_value) {
        logs.test_step("Click on " + locator_value);
        find(locator_value).click();
    }

    public void click_on_element_with_text_from_list(String element_name, String element_text_for_click) {
        logs.test_step("Click on " + element_text_for_click + " from list ");
        List<WebElement> elements_list = find_multiple_elements(element_name);
        Boolean bool = false;

        for (WebElement element : elements_list) {
            if (element.getText().contains(element_text_for_click)) {
                click(element_name);
            }
        }

    }

    public void click_using_js(WebElement element) throws Exception {
        try {
            logs.test_step("Click on " + element);
            if (element.isEnabled() && element.isDisplayed()) {
                //  System.out.println("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                //          System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            //        System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            //      System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            //        System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public void take_element_screen_shot(WebElement element, String image_name) {
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            File screenshot_file = new File("./" + image_name + ".png");
            FileUtils.copyFile(scrFile, screenshot_file);
            logs.test_step("Screenshot saved at  <img href=" + screenshot_file.getAbsolutePath() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
