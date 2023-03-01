package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageOrder {
    private WebDriver driver;
    private By buttonOrderUp = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private By buttonOrderDown = By.xpath("//*[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    public MainPageOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderButton() {
        driver.findElement(buttonOrderUp).click();
    }
    public void waitForOrderButtonDown() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonOrderDown));
    }

    public void clickOrderButtonDown() {
        driver.findElement(buttonOrderDown).click();
    }
    public void findButtonOrderDown() {
        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}

