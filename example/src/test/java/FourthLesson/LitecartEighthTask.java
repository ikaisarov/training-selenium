package FourthLesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ListIterator;


public class LitecartEighthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void litecartStiker() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> stiker = driver.findElements(By.cssSelector("li.product"));

        for (WebElement elem : stiker) {
            Assert.assertTrue(elem.findElements(By.cssSelector("div.sticker")).size() == 1);
        }
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
