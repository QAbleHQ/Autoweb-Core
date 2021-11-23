import org.openqa.selenium.WebDriver;

public class Browser {
    WebDriver driver;

    Browser(WebDriver dri) {
        this.driver = dri;
    }


    public void openURL(String url) {
        driver.get(url);
    }

}

