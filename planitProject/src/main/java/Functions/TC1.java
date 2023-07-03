package Functions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC1 {
    static WebDriver driver;
    static WebElement submitButton;
    static WebElement errorForename;
    static WebElement errorEmail;
    static WebElement errorMessage;
    static WebElement topError;
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akhil\\Documents\\Ashitha\\Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://jupiter.cloud.planittesting.com");
        driver.manage().window().maximize();
    }
    public static void goToContactPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#/contact']")).click();
        Thread.sleep(2000);
    }
    public static void clickSubmit() throws InterruptedException {
//        JavascriptExecutor js=(JavascriptExecutor) driver;
        // js.executeScript()

        submitButton= driver.findElement(By.xpath("//a[text()='Submit']"));
        submitButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    public static void verifyErrors(){

        errorForename= driver.findElement(By.xpath("//span[@id='forename-err']"));
        errorEmail= driver.findElement(By.xpath("//span[@id='email-err']"));
        errorMessage= driver.findElement(By.xpath("//span[@id='message-err']"));
        topError= driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']//strong"));

        Assert.assertTrue(errorForename.isDisplayed());
        Assert.assertTrue(errorEmail.isDisplayed());
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(topError.isDisplayed());

        System.out.println("Please enter the Mandatory fields!");
    }
    public static void enterMandatoryFields(){
        WebElement forename= driver.findElement(By.xpath("//div[@class='controls']//input[@id='forename']"));
        WebElement email= driver.findElement(By.xpath("//div[@class='controls']//input[@id='email']"));
        WebElement message= driver.findElement(By.xpath("//div[@class='controls']//textarea[@id='message']"));

        forename.sendKeys("Ashitha");
        email.sendKeys("ashitha@yahoo.com");
        message.sendKeys("Tell me about Planit");
    }
    public static boolean validateNoErrors() throws InterruptedException {
        Thread.sleep(2000);
        try {
            Assert.assertFalse(driver.findElement(By.xpath("//span[@id='forename-err']")).isDisplayed());
            Assert.assertFalse(driver.findElement(By.xpath("//span[@id='email-err']")).isDisplayed());
            Assert.assertFalse(driver.findElement(By.xpath("//span[@id='message-err']")).isDisplayed());
            Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']//strong")).isDisplayed());
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;

    }
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
