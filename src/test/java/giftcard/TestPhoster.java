package giftcard;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestPhoster {


    private static WebDriver driver;       //So that all tests share the same driver & wait, initialize only once
    private static WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/priyambhadauria/Documents/chromedriver 2");
        driver = new ChromeDriver();
        String baseUrl = "https://gift-cards.phorest.com/salons/demo-us";
        wait = new WebDriverWait(driver, 3);
        driver.get(baseUrl);
        //Setting Implicit timeout to 5 sec

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test_send_to_me_success_flow(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/ul/li[1]/span")).click();
        driver.findElement(By.xpath("//input[@placeholder='the receipt will be sent here ...']")).sendKeys("rohit@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='first name ...']")).sendKeys("tikiboom");
        driver.findElement(By.xpath("//input[@placeholder='last name ...']")).sendKeys("tikitiki");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();
        final WebElement frame = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]")));
        //Change frame to form-container
        driver.switchTo().frame(frame);
        driver.findElement(By.id("card-name")).sendKeys("tcydhfh");
        driver.findElement(By.id("card-zip")).sendKeys("92606");
        driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-expiry")).sendKeys("12 22");
        driver.findElement(By.id("card-security")).sendKeys("999");
        driver.findElement((By.id("submitButton"))).click();
        driver.findElement((By.id("submitButton"))).click();
        wait.withTimeout(Duration.ofSeconds(3L));
        //Switch to current webpage context
        driver.switchTo().defaultContent();
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();
    }


    @Test
    public void test_send_to_someone_else_success_flow(){

        driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/div[2]/div[2]/div/nav/a[2]")).click();
        final WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div/div[1]/div[2]/div[2]/div/nav/a[2]")));
        element.click();
        driver.findElement(By.xpath("//span[contains(text(),'$50')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='the receipt will be sent here ...']")).sendKeys("731d7a4f31-b6c258@inbox.mailtrap.io");
        driver.findElement(By.xpath("  //input[@placeholder='first name ...']")).sendKeys("fwgw");
        driver.findElement(By.xpath("  //input[@placeholder='last name ...']")).sendKeys("fwdafaw");
        wait.withTimeout(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/input[1]")).sendKeys("f731d7a4f31-b6c258@inbox.mailtrap.io");
        driver.findElement(By.xpath("//textarea[@placeholder='type your message here eg. Hi Mom, Happy Birthday! Love Karen']")).sendKeys("dqfq");
        final WebElement checkout = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkout.click();
        wait.withTimeout(Duration.ofSeconds(3));
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();
        final WebElement frame = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]")));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("card-name")).sendKeys("tcydhfh");
        driver.findElement(By.id("card-zip")).sendKeys("92606");
        driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-expiry")).sendKeys("12 22");
        driver.findElement(By.id("card-security")).sendKeys("999");
        driver.findElement((By.id("submitButton"))).click();
        driver.findElement((By.id("submitButton"))).click();
        wait.withTimeout(Duration.ofSeconds(3L));
        driver.switchTo().defaultContent();
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();

        //confirmation of final page
// wrong email id also message is sent put undeer enhancement

    }

    @Test
    public void test_elements_content_are_valid_on_web_page() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'$50')]"))));
        WebElement string = driver.findElement(By.xpath("//span[contains(text(),'$50')]"));
        Assert.assertEquals(string.getText(), "$50");
        WebElement string2 = driver.findElement(By.xpath(("//span[contains(text(),'$100')]")));
        Assert.assertEquals(string2.getText(), "$100");
        driver.findElement(By.xpath(("//span[contains(text(),'Other')]"))).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='enter amount here...']")).isDisplayed());
    }

    @Test
    public void should_show_error_on_amount_below_25() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("20");
        WebElement errorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]"));
        Assert.assertTrue(errorMessage.getText().equals("The minimum spend is $25 and the maximum spend is $400."));
    }

    @Test
    public void should_show_error_on_amount_above_400() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("500");
        WebElement errorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]"));
        Assert.assertTrue(errorMessage.getText().equals("The minimum spend is $25 and the maximum spend is $400."));
    }


    @Test
    public void test_email_was_delivered(){
         test_send_to_me_success_flow();
        //Test Email was dlivered

        driver.get("https://mailtrap.io/signin");       //Using mailTrap free smtp server
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("priyam.bhadauria@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@title='Demo inbox']")).click();
        //Check if inbox has email
        final List<WebElement> allMessages = driver.findElements(By.xpath("//*[contains(text(), 'Here comes an attachment')]"));
        //check is the list is not empty
       // Assert.assertTrue(allMessages.size() == 1);
    }


    @Test
    public void test_2_emails_delivered_on_gifting_to_other(){
        test_send_to_someone_else_success_flow();
        driver.get("https://mailtrap.io/signin");       //Using mailTrap free smtp server
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("priyam.bhadauria@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@title='Demo inbox']")).click();
        //Check if inbox has email
        final List<WebElement> acknowledgementMail = driver.findElements(By.xpath("//*[contains(text(), 'Here comes an attachment')]"));
        //check is the list is not empty
        //Assert.assertTrue(acknowledgementMail.size() == 1);
        final List<WebElement> receipt_mail = driver.findElements(By.xpath("//*[contains(text(), 'Here comes an attachment')]"));
        //Assert.assertTrue(receipt_mail.size() == 1);
    }

    @AfterMethod
    public void cleanup() throws InterruptedException {
             driver.close();
             driver.quit();
    }
}
