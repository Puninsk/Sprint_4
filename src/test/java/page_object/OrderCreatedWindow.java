package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderCreatedWindow {

    private WebDriver driver;

    public OrderCreatedWindow(WebDriver driver) {
        this.driver = driver;
    }

    private By orderCreatedWindow = By.xpath("//*[@class='Order_Modal__YZ-d3']/*[text()='Заказ оформлен']");

    public void waitForOrderConfirmationButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(orderCreatedWindow));
    }

}


