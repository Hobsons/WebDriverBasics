package webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by rturner on 2/28/2017.
 */
public class ThirdTest {
    public static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void setAddress(){
        driver.get("https://www.google.com/");
    }

    @Test
    public void doesChromeLoadProperly(){
        assertEquals("Check page title",driver.getTitle(), "Google");
    }

    @Test
    public void isGoogleTitleCoogle(){
        assertThat(driver.getTitle(),is("Coogle"));
    }

    @AfterClass
    public static void shutDown(){
        driver.quit();
    }
}
