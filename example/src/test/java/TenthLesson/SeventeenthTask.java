package TenthLesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SeventeenthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void logs(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> card = driver.findElements(By.cssSelector(".dataTable .row td:nth-child(3) a"));
        List<String> names = new ArrayList<>();

        for (WebElement ed : card) {
            if (ed.getAttribute("href").contains("edit_product"))
                names.add(ed.getAttribute("innerText"));
        }

            for (String vn : names){
                driver.findElement(By.linkText(vn)).click();
                Assert.assertTrue(driver.manage().logs().get("browser").getAll().size() == 0);
                driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            }
        }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
