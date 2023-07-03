package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static Functions.TC1.driver;

public class TC3 {
    static double frogP;
    static double bunnyP;
    static double bearP;
    static WebElement frogPrice;
    static WebElement bunnyPrice;
    static WebElement bearPrice;
    static double fSubtotal;
    static double buSubtotal;
    static double beSubtotal;
    public static void clickShop(){
        WebElement shop= driver.findElement(By.xpath("//a[@href='#/shop']"));
        shop.click();
    }
    public static void addProducts() throws InterruptedException {
        Thread.sleep(2000);

        WebElement stuffedFrog= driver.findElement(By.xpath("//h4[text()='Stuffed Frog']/following-sibling::p//a"));
        WebElement fluffyBunny= driver.findElement(By.xpath("//h4[text()='Fluffy Bunny']/following-sibling::p//a"));
        WebElement valentineBear= driver.findElement(By.xpath("//h4[text()='Valentine Bear']/following-sibling::p//a"));
        WebElement cartIcon= driver.findElement(By.xpath("//a[@href='#/cart']"));

        Actions act = new Actions(driver);
        act.moveToElement(stuffedFrog).doubleClick().build().perform();
        act.moveToElement(fluffyBunny).doubleClick().doubleClick().click().build().perform();
        act.moveToElement(valentineBear).doubleClick().click().build().perform();
        cartIcon.click();
        Thread.sleep(2000);

    }
    public static void calculateSubtotal(){
        WebElement frogQuantity= driver.findElement(By.xpath("//td[text()=' Stuffed Frog']/following-sibling::td[2]//input"));
        WebElement bunnyQuantity= driver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/following-sibling::td[2]//input"));
        WebElement bearQuantity= driver.findElement(By.xpath("//td[text()=' Valentine Bear']/following-sibling::td[2]//input"));

        frogPrice= driver.findElement(By.xpath("//td[text()=' Stuffed Frog']/following-sibling::td[1]"));
        bunnyPrice= driver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/following-sibling::td[1]"));
        bearPrice= driver.findElement(By.xpath("//td[text()=' Valentine Bear']/following-sibling::td[1]"));

        WebElement frogSubtotal= driver.findElement(By.xpath("//td[text()=' Stuffed Frog']/following-sibling::td[3]"));
        WebElement bunnySubtotal= driver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/following-sibling::td[3]"));
        WebElement bearSubtotal= driver.findElement(By.xpath("//td[text()=' Valentine Bear']/following-sibling::td[3]"));

        int frogQ= Integer.parseInt(frogQuantity.getAttribute("value"));
        int bunnyQ= Integer.parseInt(bunnyQuantity.getAttribute("value"));
        int bearQ= Integer.parseInt(bearQuantity.getAttribute("value"));

        frogP= Double.parseDouble((frogPrice.getText().replace("$","")));
        bunnyP= Double.parseDouble((bunnyPrice.getText().replace("$","")));
        bearP= Double.parseDouble((bearPrice.getText().replace("$","")));

        double frogS= Double.parseDouble((frogSubtotal.getText().replace("$","")));
        double bunnyS= Double.parseDouble((bunnySubtotal.getText().replace("$","")));
        double bearS= Double.parseDouble((bearSubtotal.getText().replace("$","")));

        fSubtotal= frogQ*frogP;
        buSubtotal= bunnyQ*bunnyP;
        beSubtotal= bearQ*bearP;

        Assert.assertEquals(fSubtotal,frogS);
        Assert.assertEquals(buSubtotal,bunnyS);
        Assert.assertEquals(beSubtotal,bearS);

    }
    public static void calculatePrice(){
        Assert.assertTrue(frogPrice.isDisplayed());
        Assert.assertTrue(bunnyPrice.isDisplayed());
        Assert.assertTrue(bearPrice.isDisplayed());
    }
    public static void calculateTotal(){
        WebElement total= driver.findElement(By.xpath("//strong[contains(text(),'Total')]"));
        double totalValue= Double.parseDouble((total.getText().replaceAll("[a-zA-Z:]","")));

        double sumOfSubtotal= fSubtotal+buSubtotal+beSubtotal;
        Assert.assertEquals(totalValue,sumOfSubtotal);
    }
}
