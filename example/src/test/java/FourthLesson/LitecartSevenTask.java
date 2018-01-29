package FourthLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class LitecartSevenTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void loginLitecart() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> leftmenu = driver.findElements(By.cssSelector("ul#box-apps-menu li"));
        for (int i = 1; i <= leftmenu.size(); i++) {
            driver.findElement(By.cssSelector("ul#box-apps-menu >li:nth-child(" + i + ") a")).click();
            assertTrue(areElementPresent(By.cssSelector("#content h1")));

            List<WebElement> leftmenuchild = driver.findElements(By.cssSelector("ul.docs li"));
            if(leftmenuchild.size()>0) {
                for (int k = 1; k <= leftmenuchild.size(); k++) {
                    driver.findElement(By.cssSelector("ul.docs li:nth-child(" + k + ") a")).click();
                    assertTrue(areElementPresent(By.cssSelector("#content h1")));
                }
            }
        }
    }

    @After
        public void stop(){
        driver.quit();
        driver = null;
    }


    public boolean areElementPresent( By locator) {
           
        return driver.findElements(locator).size() > 0;
    }
}

