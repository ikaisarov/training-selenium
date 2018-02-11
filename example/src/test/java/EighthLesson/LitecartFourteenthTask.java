package EighthLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

public class LitecartFourteenthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void links(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        driver.findElement(By.cssSelector(".button")).click();
        List<WebElement> arrow = driver.findElements(By.cssSelector("form tbody tr td [target='_blank']"));

        for (WebElement link : arrow){
            String original = driver.getWindowHandle();
            Set <String> oldWindows = driver.getWindowHandles();
            link.click();
            String newWindow = wait.until(anyWindow(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(original);
        }

    }

    ExpectedCondition<String> anyWindow(Set<String> oldWindows)
    {
        return driver -> {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
