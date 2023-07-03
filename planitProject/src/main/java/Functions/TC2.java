package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Functions.TC1.driver;

public class TC2 {
    public static void validateSuccess() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']//strong")));
        driver.findElement(By.xpath("//div[@class='alert alert-success']//strong")).isDisplayed();
    }
}
