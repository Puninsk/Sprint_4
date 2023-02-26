package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationWindow {

    private WebDriver driver;

    public ConfirmationWindow(WebDriver driver) {
        this.driver = driver;
    }

    private By orderConfirmationButton = By.xpath("//*[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    private By orderConfirmationWindow = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public void clickorderConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }


    public void waitForOrderConfirmationButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationWindow));
    }
}
