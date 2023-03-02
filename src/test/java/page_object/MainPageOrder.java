package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageOrder {
    private WebDriver driver;
    public static final String URL_SAMOKAT = "https://qa-scooter.praktikum-services.ru/";

    public static final String BUTTON_ORDER_DOWN = (".Home_FinishButton__1_cWm .Button_Button__ra12g.Button_Middle__1CSJM");

    public static final String BUTTON_ORDER_UP = (".Header_Nav__AGCXC .Button_Button__ra12g");
   public MainPageOrder(WebDriver driver) {
       this.driver = driver;
   }

    public void clickOrderButton(String orderButtonLocator) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(orderButtonLocator)));
        WebElement element = driver.findElement(By.cssSelector(orderButtonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.cssSelector(orderButtonLocator)).click();
    }
}

