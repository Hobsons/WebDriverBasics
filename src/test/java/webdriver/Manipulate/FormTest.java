package webdriver.Manipulate;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by rturner on 2/28/2017.
 */
public class FormTest {
    public static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void setAddress(){
        driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void checkTitleChanges() {
        driver.findElement(By.xpath("//form/table/tbody/tr[9]/td/input[2]")).click();
        assertEquals("Check page title",driver.getTitle(), "Processed Form Details");
    }

    @Test
    public void checkComments() {
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("Test comments");
        driver.findElement(By.xpath("//form/table/tbody/tr[9]/td/input[2]")).click();
        assertEquals("Check comments",driver.findElement(By.id("_valuecomments")).getText(), "Test comments");
    }

    @Test
    public void checkRadio(){
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[3]")).click();
        driver.findElement(By.xpath("//form/table/tbody/tr[9]/td/input[2]")).click();
        assertEquals("Check comments",driver.findElement(By.cssSelector("#_valueradioval")).getText(), "rd3");
    }

    @Test
    public void checkCheckbox(){
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        driver.findElement(By.xpath("//form/table/tbody/tr[9]/td/input[2]")).click();
        assertEquals("Check comments",driver.findElement(By.cssSelector("#_valuecheckboxes0")).getText(), "cb1");
    }

    @Test
    public void checkDropDown(){
        driver.findElement(By.xpath("//form[@id='HTMLFormElements']/table/tbody/tr[8]/td/select//option[5]")).click();
        driver.findElement(By.xpath("//form/table/tbody/tr[9]/td/input[2]")).click();
        assertEquals("Check comments",driver.findElement(By.cssSelector("#_valuedropdown")).getText(), "dd5");
    }

    @AfterClass
    public static void shutDown(){
        driver.quit();
    }
}
