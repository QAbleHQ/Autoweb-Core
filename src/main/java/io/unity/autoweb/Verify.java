package io.unity.autoweb;

import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class Verify {


    WebDriver driver;
    FindElement element;

    public Verify(WebDriver dri) {
        this.driver = dri;
        element = new FindElement(driver);

    }

    public boolean element_is_present(String element_name) {
        boolean bool = false;
        try {
            if (element.find(element_name).isDisplayed()) {
                bool = true;
            }
        } catch (Exception e) {

        }
        return bool;
    }

    public boolean element_is_enable(String element_name) {
        boolean bool = false;
        try {
            if (element.find(element_name).isEnabled()) {
                bool = true;
            }
        } catch (Exception e) {

        }
        return bool;
    }

    public boolean element_is_selected(String element_name) {
        boolean bool = false;
        try {
            if (element.find( element_name).isSelected()) {
                bool = true;
            }
        } catch (Exception e) {

        }
        return bool;
    }

    public void current_title_is_equal_to(String title)
    {
        assertThat(driver.getTitle()).isEqualTo(title);
    }

}
