package FifthLesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LitecartTenthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start (){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void tenthTask_a() {

        List<String> main = new ArrayList<>();
        List<String> card = new ArrayList<>();

        driver.get("http://localhost/litecart");

        main.add(driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("innerText"));
        main.add(driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("innerText"));
        main.add(driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("innerText"));

        driver.findElement(By.cssSelector("#box-campaigns .name")).click();

        card.add(driver.findElement(By.cssSelector("#box-product .title")).getAttribute("innerText"));
        card.add(driver.findElement(By.cssSelector("#box-product .campaign-price")).getAttribute("innerText"));
        card.add(driver.findElement(By.cssSelector("#box-product .regular-price")).getAttribute("innerText"));

        Assert.assertEquals(main, card);
    }
    @Test
    public void tenthTask_v (){
        driver.get("http://localhost/litecart");
        String line = "line-through";
        String textdecor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("text-decoration");
        String linetest = textdecor.substring(0,12);
        Assert.assertEquals(line, linetest);

        String color = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        String replace=color.replace(" ","");
        String[] arr = replace.substring(replace.indexOf("(")+1,replace.lastIndexOf(")")).split("\\,");
        for (int i=0; i < 2 ;i++) {
            String vfg = arr[i];
            String bgh = arr[i + 1];
            Assert.assertEquals(vfg,bgh);
            }

        driver.findElement(By.cssSelector("#box-campaigns .name")).click();

        String textdecorcard = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("text-decoration");
        String linetestcard = textdecorcard.substring(0,12);
        Assert.assertEquals(line, linetestcard);

        String colorcard = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("color");
        String replacecard=colorcard.replace(" ","");
        String[] arrcard = replacecard.substring(replacecard.indexOf("(")+1,replacecard.lastIndexOf(")")).split("\\,");
        for (int i=0; i < 2 ;i++) {
            String vfg = arrcard[i];
            String bgh = arrcard[i + 1];
            Assert.assertEquals(vfg,bgh);
        }
        }

     @Test
     public void tenthTask_g(){
         driver.get("http://localhost/litecart");
         String boldcard = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-weight");
         Assert.assertTrue( "bold".equals(boldcard) || "bolder".equals(boldcard) || Integer.parseInt(boldcard) >= 700);

         String salecolor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
         String replace=salecolor.replace(" ","");
         String[] arr = replace.substring(replace.indexOf("(")+1,replace.lastIndexOf(")")).split("\\,");
         String nb = arr[1];
         String mk = arr[2];
         Assert.assertEquals(nb, "0");
         Assert.assertEquals(mk, "0");

         Double font = Double.parseDouble(driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size").replace("px",""));
         Double salefont = Double.parseDouble(driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size").replace("px",""));

         driver.findElement(By.cssSelector("#box-campaigns .name")).click();

         String boldcardcd = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("font-weight");
         Assert.assertTrue( "bold".equals(boldcardcd) || "bolder".equals(boldcardcd) || Integer.parseInt(boldcardcd) >= 700);

         String salecolorcard = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("color");
         String replacecard=salecolor.replace(" ","");
         String[] arrcard = replacecard.substring(replacecard.indexOf("(")+1,replacecard.lastIndexOf(")")).split("\\,");
         String nk = arr[1];
         String rt = arr[2];
         Assert.assertEquals(nk, "0");
         Assert.assertEquals(rt, "0");

         Double cardfont = Double.parseDouble(driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("font-size").replace("px",""));
         Double cardsalefont = Double.parseDouble(driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("font-size").replace("px",""));

         Assert.assertTrue(font < salefont);
         Assert.assertTrue(cardfont < cardsalefont);
     }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
