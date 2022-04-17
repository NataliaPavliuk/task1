
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class main {
    @Test
    public void SearchImg() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dimg_15']")));
            driver.findElement(By.xpath(".//*[@id='dimg_15']")).click();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("task1"));
            Assert.assertTrue(driver.getTitle().contains("cheese"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
