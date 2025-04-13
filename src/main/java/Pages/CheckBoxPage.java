package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage {
    private WebDriver driver;
    By checkBox1 = By.xpath("//input[@type='checkbox'][1]");
    By checkBox2 = By.xpath("//input[@type='checkbox'][2]");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckBox1() {
        driver.findElement(checkBox1).click();
    }
    public Boolean areBothSelected()
    {
        return driver.findElement(checkBox1).isSelected() && driver.findElement(checkBox2).isSelected();
    }

}
