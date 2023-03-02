package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Faq {
    private WebDriver driver;

    private By cookiesAcceptButton = By.xpath("//button[text()='да все привыкли']");

    private By faqSectorEnds = By.xpath("//*[@id=\"accordion__heading-7\"]");
    public static final String URL_SAMOKAT = "https://qa-scooter.praktikum-services.ru/";

    public static final String FIRST_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-0\"]";
    public static final String SECOND_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-1\"]";
    public static final String THIRD_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-2\"]";
    public static final String FORTH_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-3\"]";
    public static final String FIFTH_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-4\"]";
    public static final String SIXTH_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-5\"]";
    public static final String SEVENTH_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-6\"]";
    public static final String EIGHTS_QUESTION_TITLE_LOCATOR = "//*[@id=\"accordion__heading-7\"]";

    public static final String FIRST_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-0']/p";

    public static final String SECOND_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-1']/p";

    public static final String THIRD_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-2']/p";

    public static final String FORTH_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-3']/p";

    public static final String FIFTH_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-4']/p";

    public static final String SIXTH_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-5']/p";

    public static final String SEVENTH_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-6']/p";

    public static final String EIGHTS_QUESTION_TEXT_LOCATOR = "//*[@id='accordion__panel-7']/p";

    public static final String FIRST_QUESTION_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    public static final String SECOND_QUESTION_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String THIRD_QUESTION_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String FORTH_QUESTION_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String FIFTH_QUESTION_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String SIXTH_QUESTION_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String SEVENTH_QUESTION_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EIGHTS_QUESTION_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public Faq(WebDriver driver) {
        this.driver = driver;
    }

    public String getQuestionText(String questionToOpen, String questionTextLocator) {
        driver.findElement(By.xpath(questionToOpen)).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionTextLocator)));
        return driver.findElement(By.xpath(questionTextLocator)).getText();
    }

    public void acceptCookieClick() {
        driver.findElement(cookiesAcceptButton).click();
    }

    public void findFaqSection() {
        WebElement element = driver.findElement(faqSectorEnds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}