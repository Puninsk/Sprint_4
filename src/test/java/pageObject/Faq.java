package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Faq {
    private WebDriver driver;

    private By cookiesAcceptButton = By.xpath("//button[text()='да все привыкли']");

    private By FaqSectorEnds = By.xpath("//*[@id=\"accordion__heading-7\"]");

    public Faq(WebDriver driver) {
        this.driver = driver;
    }

    public String getQuestionText(String QuestionToOpen, String questionTextLocator) {
        driver.findElement(By.xpath(QuestionToOpen)).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionTextLocator)));
        return driver.findElement(By.xpath(questionTextLocator)).getText();
    }

    public void acceptCookieClick() {
        driver.findElement(cookiesAcceptButton).click();
    }

    public void findFaqSection() {
        WebElement element = driver.findElement(FaqSectorEnds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}