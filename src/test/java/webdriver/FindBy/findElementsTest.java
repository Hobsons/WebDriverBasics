package webdriver.FindBy;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rturner on 2/28/2017.
 */
public class findElementsTest {
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
    public void returnAllElementsByClassName(){
        List<WebElement> elements;
        elements = driver.findElements(By.className("normal"));
        Set<String> foundTags = new HashSet<String>();
        for(WebElement e : elements){
            foundTags.add(e.getTagName().toLowerCase());
            }
        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("ul"));
        assertTrue("expected li tag", foundTags.contains("li"));
        assertTrue("expected a tag", foundTags.contains("a"));
        assertFalse("did not expect div tag", foundTags.contains("div"));
    }


    @AfterClass
    public static void shutDown(){
        driver.quit();
    }
}
