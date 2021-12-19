package io.unity.autoweb;

import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class Verify {


    WebDriver driver;
    Element element;

    public Verify(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

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

    public void element_text_is_equal_to(String element_name,String text_to_verify)
    {
        assertThat(element.find(element_name)).isEqualTo(text_to_verify);
    }





}
