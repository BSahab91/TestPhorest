import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Main {


    private static WebDriver driver;       //So that all tests share the same driver, initialize only once
    private static WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/priyambhadauria/Documents/chromedriver 2");
        driver = new ChromeDriver();
        String baseUrl = "https://gift-cards.phorest.com/salons/demo-us";
        wait = new WebDriverWait(driver,3);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test_send_to_me_success_flow() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/ul/li[1]/span")).click();
// make your own x path
        driver.findElement(By.xpath("//input[@placeholder='the receipt will be sent here ...']")).sendKeys("rohit@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='first name ...']")).sendKeys("tikiboom");
        driver.findElement(By.xpath("//input[@placeholder='last name ...']")).sendKeys("tikitiki");

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();
        final WebElement frame = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]"));
        //final is used to follow good coding practices
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

        System.out.println("Test success");



        //msg appear
    }


    // Add waits explicit and implicit
    @Test
    public void test_send_to_someone_else_success_flow() throws InterruptedException {

//        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/div[2]/div[2]/div/nav/a[2]")).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div/div[1]/div[2]/div[2]/div/nav/a[2]")));
        element.click();
        driver.findElement(By.xpath("//span[contains(text(),'$50')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='the receipt will be sent here ...']")).sendKeys("xyz@cv.com");
        driver.findElement(By.xpath("  //input[@placeholder='first name ...']")).sendKeys("fwgw");
        driver.findElement(By.xpath("  //input[@placeholder='last name ...']")).sendKeys("fwdafaw");
        wait.withTimeout(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/input[1]")).sendKeys("fteaw@wrw.com");
        driver.findElement(By.xpath("//textarea[@placeholder='type your message here eg. Hi Mom, Happy Birthday! Love Karen']")).sendKeys("dqfq");
        //wait.withTimeout(Duration.ofSeconds(2));
        WebElement checkout = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkout.click();
        wait.withTimeout(Duration.ofSeconds(3));
        driver.findElement((By.xpath("//button[@class='btn w-btn h-btn mx-auto border-brand bg-brand shadow-brand-md text-white text-lg leading-tight']"))).click();
        final WebElement frame = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/iframe[1]"));
        //final is used to follow good coding practices
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

        System.out.println("Test success for second method");


    }

    @After
    public void cleanup() throws InterruptedException {
        //wait.withTimeout(Duration.ofSeconds(4));
        driver.quit();
    }
}


/*
  // driver.findElement(By.id("card-name")).sendKeys("jun");
        //driver.findElement(By.id("//body[@class='text-phorest-gray font-light h-full flex flex-col bg-white']")).sendKeys("92606");
        //  driver.findElement(By.id("//body[@class='text-phorest-gray font-light h-full flex flex-col bg-white']")).sendKeys("4111 1111 1111 1111");
        //    driver.findElement(By.id("//body[@class='text-phorest-gray font-light h-full flex flex-col bg-white']")).sendKeys("12/22");
        //   driver.findElement(By.id("//body[@class='text-phorest-gray font-light h-full flex flex-col bg-white']")).sendKeys("999");
        // driver.findElement((By.xpath("//body[@class='text-phorest-gray font-light h-full flex flex-col bg-white']"))).click();
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        //  WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"card-name\"]")));
        //   passwordElement.click();
        //   passwordElement.sendKeys("123");
        //input[@placeholder='the receipt will be sent here ...']
 */