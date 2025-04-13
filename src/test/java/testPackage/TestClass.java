package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {


    WebDriver driver = new ChromeDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void testOne()
    {
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
        driver.quit();

    }


    @Test
    public void testTwo()
    {
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img"))));
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img")).isDisplayed());
        driver.close();

    }

    /**
     * Test case to search for Selenium WebDriver on DuckDuckGo and verify the URL of the first result
     */
    @Test
    public void testThree()
    {
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//input[@name='q']//..//div//button[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-layout='organic']")));
        driver.findElement(By.xpath("(//li[@data-layout='organic'][1]//a)[5]")).click(); //will select the first
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/webdriver/");
        //driver.close();

    }


    @Test
    public void testFour()
    {
        //change to firefox
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("TestNG");
        driver.findElement(By.xpath("//input[@name='q']//..//div//button[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-layout='organic']")));
        String fourthTestResult=driver.findElement(By.xpath("(//li[@data-layout='organic'][4])//article")).getText();
        System.out.println(fourthTestResult);
        Assert.assertTrue(fourthTestResult.equals("TestNG Tutorial"));
        //driver.close();

    }


    @Test
    public void testFive()
    {
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Cucumber IO");
        driver.findElement(By.xpath("//input[@name='q']//..//div//button[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-layout='organic']")));
        String SecondTestResult=driver.findElement(By.xpath("(//li[@data-layout='organic'][2])//article")).getText();
        System.out.println(SecondTestResult);
        Assert.assertTrue(SecondTestResult.contains("https://www.linkedin.com"));
        //driver.close();

    }


    @Test
    public void testSix()
    {

        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected() && driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());

    }


    @Test
    public void testSeven()
    {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        String country=driver.findElement(By.xpath("//td[contains(text(),'Ernst Hande')]/following-sibling::td[2]")).getText();
        System.out.println(country);
        Assert.assertEquals(country,"Austria");

    }

    @Test
    public void testEight()
    {

        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        WebElement fileInput=driver.findElement(By.xpath("//input[@id='file-upload']"));
        String filePath="C:\\Users\\HP\\Desktop\\testImage.jpg";
        System.out.println(filePath);
        fileInput.sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3")));
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");

    }

    @Test
    public void testNine()
    {

        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='droppable']//p")).getText(),"Dropped!");



    }



}
