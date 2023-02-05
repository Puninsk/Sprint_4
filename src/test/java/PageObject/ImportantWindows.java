package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImportantWindows {

    private WebDriver driver;

    private By firstImportantWindow = By.xpath("//*[@id=\"accordion__heading-0\"]");

    private By secondImportantWindow = By.xpath("//*[@id=\"accordion__heading-1\"]");

    private By thirdImportantWindow = By.xpath("//*[@id=\"accordion__heading-2\"]");

    private By forthImportantWindow = By.xpath("//*[@id=\"accordion__heading-3\"]");

    private By fifthImportantWindow = By.xpath("//*[@id=\"accordion__heading-4\"]");

    private By sixthImportantWindow = By.xpath("//*[@id=\"accordion__heading-5\"]");

    private By seventhImportantWindow = By.xpath("//*[@id=\"accordion__heading-6\"]");

    private By eightsImportantWindow = By.xpath("//*[@id=\"accordion__heading-7\"]");

    private By cookiesAcceptButton = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    public ImportantWindows(WebDriver driver) {
        this.driver = driver;
    }

    //WebElement element = driver.findElement(firstImportantWindow);
//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//*[@id="rcc-confirm-button"]

    public void acceptCookieClick() {
        driver.findElement(cookiesAcceptButton).click();
    }
    public void clickFirstImportantWindow() {
        driver.findElement(firstImportantWindow).click();
    }

    public void clickSecondImportantWindow() {
        driver.findElement(secondImportantWindow).click();
    }

    public void clickThirdImportantWindow() {
        driver.findElement(thirdImportantWindow).click();
    }

    public void clickForthImportantWindow() {
        driver.findElement(forthImportantWindow).click();
    }

    public void clickFifthImportantWindow() {
        driver.findElement(fifthImportantWindow).click();
    }

    public void clickSixthImportantWindow() {
        driver.findElement(sixthImportantWindow).click();
    }

    public void clickSeventhImportantWindow() {
        driver.findElement(seventhImportantWindow).click();
    }

    public void clickEightsImportantWindow() {
        driver.findElement(eightsImportantWindow).click();
    }

    public void clickImportantWindows() {
        acceptCookieClick();
        clickFirstImportantWindow();
        clickSecondImportantWindow();
        clickThirdImportantWindow();
        clickForthImportantWindow();
        clickFifthImportantWindow();
        clickSixthImportantWindow();
        clickSeventhImportantWindow();
        clickEightsImportantWindow();
    }


    public void waitForPage() {
        Assert.assertTrue(driver.findElement(firstImportantWindow).isEnabled());
    }

}
