package checkbox;

import Pages.CheckBoxPage;
import testPackage.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckBoxTests extends BaseTests {
    private CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void testCheckBoxesSelected() {
        checkBoxPage.clickCheckBox1();
        Assert.assertTrue(checkBoxPage.areBothSelected());
    }
}
