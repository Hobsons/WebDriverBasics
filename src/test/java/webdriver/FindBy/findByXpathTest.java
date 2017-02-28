package webdriver.FindBy;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by rturner on 2/28/2017.
 */
public class findByXpathTest {
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
    public void byIDTest(){
        assertEquals("Verify id p31",driver.findElement(By.xpath("//*[@id='p31']")).getAttribute("name"),"pName31");
    }

    @Test
    public void byNameTest(){
        assertEquals("Verify name ulName1",driver.findElement(By.xpath("//*[@name='ulName1']")).getAttribute("id"),"ul1");
    }

    @Test
    public void byClassNameTest(){
        assertEquals("Verify className specialDiv",driver.findElement(By.xpath("//div[@class='specialDiv']")).getAttribute("id"),"div1");
    }

    @Test
    public void bytagNameTest(){
        assertEquals("Verify tagName li",driver.findElement(By.xpath("//li")).getAttribute("name"),"liName1");
    }

    @AfterClass
    public static void shutDown(){
        driver.quit();
    }
}
