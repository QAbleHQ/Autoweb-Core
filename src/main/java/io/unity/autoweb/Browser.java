package io.unity.autoweb;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Browser {
    WebDriver driver;
    Element element;

    public Browser(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

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
        element.find(elementName).click();
    }

    public void enter_text(String element_name, String text_to_enter) {
        element.find(element_name).sendKeys(text_to_enter);
    }






    public void close_browser() {
        driver.quit();
    }

    public void take_page_screenshot(String image_name) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            create_screenshot_dir();
            FileUtils.copyFile(scrFile, new File("./screenshot/" + image_name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void create_screenshot_dir() throws IOException {
        Path screen_shot_path = Paths.get("./" + "screenshot");
        if (!Files.isDirectory(screen_shot_path)) {
            Files.createTempDirectory(screen_shot_path.toAbsolutePath().toString());
        }


    }


    public void take_page_screenshot(String folder_path, String image_name) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(folder_path + "/" + image_name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void take_element_screen_shot(WebElement element, String image_name) {
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + image_name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

