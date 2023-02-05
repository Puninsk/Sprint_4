package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillOrderFormPageTwo {

    private WebDriver driver;

    private By dateOfOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    private By chooseRentPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/span");
    private By clickRentPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");
    private By chooseColor = By.xpath("//*[@id=\"black\"]");
    private By buttonOrderPageTwo = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    public FillOrderFormPageTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateOfOrder(String userDateOfOrder) {
        driver.findElement(dateOfOrder).sendKeys(userDateOfOrder);
    }

    public void clickChooseRentPeriod() {
        driver.findElement(chooseRentPeriod).click();
    }

    public void setColor() {
        driver.findElement(chooseColor).click();
    }
    public void clickRentPeriod() {
        driver.findElement(clickRentPeriod).click();
    }

    public void fillOrderFormPageOne(String userDateOfOrder) {
        setDateOfOrder(userDateOfOrder);
        clickChooseRentPeriod();
        clickRentPeriod();
        setColor();
    }

    public void waitForPageTwoLoad() {
        Assert.assertTrue(driver.findElement(dateOfOrder).isEnabled());
    }

    public void clickButtonOrderPageTwo() {
        driver.findElement(buttonOrderPageTwo).click();
    }

    public void waitForButtonOrderPageTwoLoad() {
        Assert.assertTrue(driver.findElement(buttonOrderPageTwo).isEnabled());
    }
}
