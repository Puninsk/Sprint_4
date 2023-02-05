package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class MainPageOrder {
    private WebDriver driver;
    private By buttonOrderUp = By.cssSelector(("div.Header_Nav__AGCXC > button.Button_Button__ra12g"));
    private By buttonOrderDown = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button");


    public MainPageOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderButton() {
        driver.findElement(buttonOrderUp).click();
    }

    public void waitForOrderButtonDown() {
        Assert.assertTrue(driver.findElement(buttonOrderDown).isEnabled());
    }

    public void clickOrderButtonDown() {
        driver.findElement(buttonOrderDown).click();
    }
}
