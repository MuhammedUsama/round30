package testPackage;

import Pages.DuckDuckGoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DuckTests extends testPackage.BaseTests {

    private DuckDuckGoPage duckPage;
    @BeforeMethod
    public void pageSetup() {
        driver.get("https://duckduckgo.com/");
        duckPage = new DuckDuckGoPage(driver);

    }

    @Test
    public void checkIfPageTitleIsGoogle()
    {
        String title=duckPage.getTitle();
        Assert.assertEquals(title,"Google");

    }

    @Test
    public void checkIfPageLogoIsDisplayed()
    {
        Assert.assertTrue(duckPage.PageLogoPresent());
    }


    @Test
    public void searchForSeleniumAndCheckFirstResultLink()
    {
        String link=duckPage.getLinkOfnSearchResult("Selenium WebDriver",1);
        //String link=duckPage.getLinkOfnSearchResultList("Selenium WebDriver",0);
        //String link=duckPage.getURLofFirstSearchResult("Selenium WebDriver");
        Assert.assertEquals(link,"https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void searchForTestNGAndCheckFourthResultText()
    {
        String text=duckPage.getTextOfnSearchResult("TestNG",4);
        //String text=duckPage.getTextOfnSearchResultList("TestNG",3);
        //String text=duckPage.getTextOfFourthSearchResult("TestNG");
        Assert.assertEquals(text,"TestNG Tutorial");
    }

    @Test
    public void searchForCucumberAndCheckSecondResultLink()
    {
        String url=duckPage.getLinkOfnSearchResult("Cucumber IO",2);
        //String url=duckPage.getLinkOfnSearchResultList("Cucumber IO",1);
        //String url=duckPage.getTextOfFourthSearchResult("Cucumber IO");
        Assert.assertTrue(url.contains("https://www.linkedin.com"));
    }




}
