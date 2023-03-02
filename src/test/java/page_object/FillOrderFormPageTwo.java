package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillOrderFormPageTwo {
    private WebDriver driver;
    private By dateOfOrder = By.cssSelector(".react-datepicker__input-container .Input_Input__1iN_Z.Input_Responsible__1jDKN");
    private By chooseRentPeriod = By.cssSelector(".Dropdown-arrow-wrapper .Dropdown-arrow");
    private By clickRentPeriod = By.xpath("//div[text()='трое суток']");
    private By chooseColor = By.xpath("//*[@id=\"black\"]");

    private By buttonOrderPageTwo = By.xpath("//*[@class='Order_Buttons__1xGrp']/*[text()='Заказать']");

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
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(dateOfOrder));
    }
    public void clickButtonOrderPageTwo() {
        driver.findElement(buttonOrderPageTwo).click();
    }
    public void waitForButtonOrderPageTwoLoad() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonOrderPageTwo));
    }
}





