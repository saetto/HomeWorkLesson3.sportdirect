package FirstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by Veronika on 4/3/2017.
 */
public class MainPage {

    @Test

    public void firstTest() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://lv.sportsdirect.com");

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.className("TopNavBar"));
        element.click();

        WebElement sport=driver.findElement(By.xpath("//*[@id=\"topMenu\"]/ul/li[6]/a"));
        sport.click();

        WebElement swimmingElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29808065_HtmlModule_lblContent\"]/div/div/div[2]/div[1]/ul/li[32]/a/h2")));
        swimmingElement.click();

        WebElement swimmingSuitsElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29808104_HtmlModule_lblContent\"]/div[2]/div[1]/div/div/div[3]/div[1]/div/div/nav/ul/li[7]/a")));
        swimmingSuitsElement.click();

        Thread.sleep(1000);

        WebElement girlsElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[3]/a/span/span[1]")));
        girlsElement.click();
        WebElement girlsElementValue = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[3]/a/span/span[2]")));
        String text2 = girlsElementValue.getText();
        String text3=text2.replace("(",""  ).replace(")", "");
        int girlsValue= Integer.parseInt(text3);

        WebElement unisexElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[2]/a/span/span[1]")));
        unisexElement.click();
        Thread.sleep(1000);
        WebElement unisexElementValue = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[2]/a/span/span[2]")));
        String text = unisexElementValue.getText();
        String text1=text.replace("(",""  ).replace(")", "");
        int unisexValue= Integer.parseInt(text1);

        Assert.assertEquals(3, girlsValue+unisexValue);

        driver.quit();
    }
}
