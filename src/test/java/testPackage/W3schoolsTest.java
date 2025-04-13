package testPackage;


import Pages.W3schoolsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class W3schoolsTest extends testPackage.BaseTests {

    private W3schoolsPage w3schoolsPage;

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        w3schoolsPage = new W3schoolsPage(driver);
    }

    @Test
    public void CountryTest()
    {
        Assert.assertEquals(w3schoolsPage.getErnstHandeCountry(), "Austria");
    }

}
