package SixthLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LitecartElevenTask {

    private WebDriver driver;
    private WebDriverWait wait;
    public Actions actions;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void registration(){
        String email = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()) + "@gmail.com";
        String password = "12345";


        driver.get("http://localhost/litecart");
        driver.findElement(By.cssSelector(".content td a")).click();


        driver.findElement(By.cssSelector(".content td [name=tax_id]")).sendKeys("222");
        driver.findElement(By.cssSelector(".content td [name=company]")).sendKeys("TEK");
        driver.findElement(By.cssSelector(".content td [name=firstname]")).sendKeys("Mark");
        driver.findElement(By.cssSelector(".content td [name=lastname]")).sendKeys("Loos");
        driver.findElement(By.cssSelector(".content td [name=address1]")).sendKeys("Street LA");
        driver.findElement(By.cssSelector(".content td [name=address2]")).sendKeys("20A");
        driver.findElement(By.cssSelector(".content td [name=postcode]")).sendKeys("89563");
        driver.findElement(By.cssSelector(".content td [name=city]")).sendKeys("London");

        actions = new Actions(driver);
        WebElement country = driver.findElement(By.cssSelector(".content td .selection"));
        actions.click(country).sendKeys("United States").sendKeys(Keys.ENTER).release().perform();

        driver.findElement(By.cssSelector(".content td [name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector(".content td [name=phone]")).sendKeys(Keys.HOME +  "8800200600");
        driver.findElement(By.cssSelector(".content td [name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector(".content td [name=confirmed_password]")).sendKeys(password);

        driver.findElement(By.cssSelector(".content td [name=create_account]")).click();
        driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();

        driver.findElement(By.cssSelector("#box-account-login td [name=email")).sendKeys(email);
        driver.findElement(By.cssSelector("#box-account-login td [name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("#box-account-login td [name=login]")).click();
        driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();



    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
