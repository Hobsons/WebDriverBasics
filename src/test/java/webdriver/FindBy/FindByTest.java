package webdriver.FindBy;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by rturner on 2/28/2017.
 */
public class FindByTest {
    public static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void setAddress(){
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void doesChromeLoadProperly(){
        assertEquals("Check page title",driver.getTitle(), "Welcome to the Find By Playground");
    }

    @Test
    public void byIDTest(){
        assertEquals("Verify id p14 is identified",driver.findElement(By.id("p14")).getText(),"This is n paragraph text");
    }

    @Test
    public void byLinkTextTest(){
        assertEquals("Verify jump to para 15 identified",driver.findElement(By.linkText("jump to para 15")).getText(),"jump to para 15");
    }

    @Test
    public void byNameTest(){
        assertEquals("Verify name pname5 is identified",driver.findElement(By.name("pName5")).getText(),"This is e paragraph text");
    }

    @Test
    public void byPartialLinkTextTest(){
        assertEquals("Verify jump to para 15 identified",driver.findElement(By.partialLinkText("para 15")).getText(),"jump to para 15");
    }

    @AfterClass
    public static void shutDown(){
        driver.quit();
    }
}
