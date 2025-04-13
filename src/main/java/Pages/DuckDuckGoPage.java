package Pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DuckDuckGoPage {


    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Bot bot;
    By logo = By.xpath("//div[contains(@class,'Desktop')]//img");
    By SearchBox = By.xpath("//input[@name='q']");
    By SearchButton = By.xpath("//input[@name='q']//..//div//button[2]");
    //using XPath Index
    By SearchResultLinks=By.xpath("");
    By SearchResultTexts=By.xpath("");
    //using list
    By SearchResultLinksList=By.xpath("//a[@data-testid='result-extras-url-link']");
    By SearchResultTextsList=By.xpath("//a[@data-testid='result-title-a']//span");
    //unused
    By FirstSearchResult = By.xpath("(//li[@data-layout='organic'][1]//a)[5]");
    By FourthSearchResult = By.xpath("(//li[@data-layout='organic'][4]//a)[5]");
    By SecondSearchResult = By.xpath("(//li[@data-layout='organic'][2]//a)[5]");

    public DuckDuckGoPage(WebDriver driver) {
        this.driver = driver;
        bot =new Bot(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean PageLogoPresent() {

        return bot.isDisplayed(logo);
        //wait.until(d -> driver.findElement(logo).isDisplayed());
        //return driver.findElement(logo).isDisplayed();
    }
    //using XPath Index
    public String getLinkOfnSearchResult(String searchText,int index) {
        bot.sendKeys(SearchBox,searchText);
        bot.click(SearchButton);
        SearchResultLinks = By.xpath("(//a[@data-testid='result-extras-url-link'])["+index+"]");
        System.out.println(SearchResultLinks);
        System.out.println(bot.getDomAttribute(SearchResultLinks,"href"));
        return bot.getDomAttribute(SearchResultLinksList,"href");
    }

    public String getTextOfnSearchResult(String searchText,int index) {
        bot.sendKeys(SearchBox,searchText);
        bot.click(SearchButton);
        SearchResultTexts=By.xpath("(//a[@data-testid='result-title-a']//span)["+index+"]");
        System.out.println(SearchResultTexts);
        System.out.println(bot.getText(SearchResultTexts));
        return bot.getText(SearchResultTexts);
    }

    //using List
    public String getLinkOfnSearchResultList(String searchText,int index) {

        bot.sendKeys(SearchBox,searchText);
        bot.click(SearchButton);
        return bot.getElementFromList(SearchResultLinksList,index).getDomAttribute("href");
        //wait.until(d -> driver.findElements(SearchResultLinks));
        //List<WebElement> links = driver.findElements(SearchResultLinks);
        //return links.get(index).getDomAttribute("href");
    }

    public String getTextOfnSearchResultList(String searchText,int index) {

        bot.sendKeys(SearchBox,searchText);
        bot.click(SearchButton);
        return bot.getElementFromList(SearchResultTextsList,index).getText();
        //wait.until(d -> driver.findElements(SearchResultTexts));
        //List<WebElement> texts = driver.findElements(SearchResultTexts);
        //return texts.get(index).getText();
    }

    //unused
    public String getURLofFirstSearchResult(String searchText) {


        wait.until(d -> driver.findElement(SearchBox).isDisplayed());
        driver.findElement(SearchBox).sendKeys(searchText);
        driver.findElement(SearchButton).click();
        wait.until(d -> driver.findElement(FirstSearchResult).isDisplayed());
        driver.findElement(FirstSearchResult).click();
        return driver.getCurrentUrl();
    }

    public String getTextOfFourthSearchResult(String searchText) {


        wait.until(d -> driver.findElement(SearchBox).isDisplayed());
        driver.findElement(SearchBox).sendKeys(searchText);
        driver.findElement(SearchButton).click();
        wait.until(d -> driver.findElement(FourthSearchResult).isDisplayed());
        return driver.findElement(FourthSearchResult).getText();
    }

    public String getTextOfSecondSearchResult(String searchText) {


        wait.until(d -> driver.findElement(SearchBox).isDisplayed());
        driver.findElement(SearchBox).sendKeys(searchText);
        driver.findElement(SearchButton).click();
        wait.until(d -> driver.findElement(SecondSearchResult).isDisplayed());
        return driver.findElement(SecondSearchResult).getText();
    }



}
