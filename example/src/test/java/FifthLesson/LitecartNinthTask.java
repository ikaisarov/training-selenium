package FifthLesson;

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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LitecartNinthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void loginLitecart(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> country = driver.findElements(By.cssSelector("tr.row>td:nth-child(5)"));

        Collections.sort(country, new Comparator<WebElement>(){
            public int compare(WebElement e1, WebElement e2){
                return e1.getAttribute("innerText").compareToIgnoreCase(e2.getAttribute("innerText"));
            }
        });

        List<WebElement> country_orig = new ArrayList<>(country);
        Assert.assertEquals(country_orig, country);




        List<WebElement> table = driver.findElements(By.cssSelector(".row"));
        List<String> zone = new ArrayList<>();

        for (WebElement ver : table)
            if (!(ver.findElement(By.cssSelector("tr.row>td:nth-child(6)")).getAttribute("innerText")).equals("0")){
                zone.add(ver.findElement(By.cssSelector("tr.row>td:nth-child(5)")).getAttribute("innerText"));
            }

        for (String det : zone){
                driver.findElement(By.linkText(det)).click();
                List<WebElement> tablezone = driver.findElements(By.cssSelector("#table-zones td:nth-child(3)"));
                List<String> tablezone2 = new ArrayList<>();
                for (WebElement rt : tablezone){
                    String attr = rt.getAttribute("innerText");
                    if(!attr.isEmpty()){
                        tablezone2.add(rt.getAttribute("innerText"));
                    }
                }
                List<WebElement> zone_orig = new ArrayList(tablezone2);
                Collections.sort(tablezone, new Comparator<WebElement>(){
                public int compare(WebElement e1, WebElement e2){
                    return e1.getAttribute("innerText").compareToIgnoreCase(e2.getAttribute("innerText"));
                }
            });
                Assert.assertEquals(zone_orig,tablezone2) ;

                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
       }

       @Test
       public void geozones(){
           driver.get("http://localhost/litecart/admin");
           driver.findElement(By.name("username")).sendKeys("admin");
           driver.findElement(By.name("password")).sendKeys("admin");
           driver.findElement(By.name("login")).click();

           driver.findElement(By.cssSelector("#box-apps-menu-wrapper li:nth-child(6)")).click();

           List<WebElement> zone = driver.findElements(By.cssSelector(".dataTable .row td:nth-child(3)"));
           ArrayList<String> countries = new ArrayList<String>();

           for (WebElement el : zone){
               countries.add(el.getAttribute("innerText"));
           }

           for (String cds : countries) {
               driver.findElement(By.linkText(cds)).click();
               zone = driver.findElements(By.cssSelector(".dataTable tr td:nth-child(3) select option:checked"));
               List<String> geozones = new ArrayList<>();
               for (WebElement el : zone) {
                   geozones.add(el.getAttribute("innerText"));
               }

               List<String> geozones_sort = new ArrayList<>(geozones);
               Collections.sort(geozones_sort);
               Assert.assertEquals(geozones_sort,geozones);

               driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
           }


       }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
