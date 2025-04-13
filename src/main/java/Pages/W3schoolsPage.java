package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3schoolsPage {
    private WebDriver driver;
    private By ErnstHandeCountry = By.xpath("//td[contains(text(),'Ernst Hande')]/following-sibling::td[2]");


    public W3schoolsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getErnstHandeCountry() {
        return driver.findElement(ErnstHandeCountry).getText();
    }
}
