package webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rturner on 2/28/2017.
 */
public class SecondTest {
    @Test
    public void doesChromeLoadProperly(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        assertEquals("Check page title",driver.getTitle(), "Coogle");
        driver.quit();
    }
}
