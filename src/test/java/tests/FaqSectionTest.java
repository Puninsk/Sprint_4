package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.Faq;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqSectionTest {
    private WebDriver driver;

    private final String expectedQuesitonTextFaq;

    private final String locatorFaqQuestion;

    private final String questionToOpen;

    public FaqSectionTest(String questionToOpen, String locatorFaqQuestion, String expectedQuesitonTextFaq) {
        this.questionToOpen = questionToOpen;
        this.locatorFaqQuestion = locatorFaqQuestion;
        this.expectedQuesitonTextFaq = expectedQuesitonTextFaq;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionText() {
        return new Object[][]{
                {Faq.FIRST_QUESTION_TITLE_LOCATOR , Faq.FIRST_QUESTION_TEXT_LOCATOR, Faq.FIRST_QUESTION_TEXT},
                {Faq.SECOND_QUESTION_TITLE_LOCATOR, Faq.SECOND_QUESTION_TEXT_LOCATOR, Faq.SECOND_QUESTION_TEXT},
                {Faq.THIRD_QUESTION_TITLE_LOCATOR, Faq.THIRD_QUESTION_TEXT_LOCATOR, Faq.THIRD_QUESTION_TEXT},
                {Faq.FORTH_QUESTION_TITLE_LOCATOR, Faq.FORTH_QUESTION_TEXT_LOCATOR, Faq.FORTH_QUESTION_TEXT},
                {Faq.FIFTH_QUESTION_TITLE_LOCATOR, Faq.FIFTH_QUESTION_TEXT_LOCATOR, Faq.FIFTH_QUESTION_TEXT},
                {Faq.SIXTH_QUESTION_TITLE_LOCATOR, Faq.SIXTH_QUESTION_TEXT_LOCATOR, Faq.SIXTH_QUESTION_TEXT},
                {Faq.SEVENTH_QUESTION_TITLE_LOCATOR, Faq.SEVENTH_QUESTION_TEXT_LOCATOR, Faq.SEVENTH_QUESTION_TEXT},
                {Faq.EIGHTS_QUESTION_TITLE_LOCATOR, Faq.EIGHTS_QUESTION_TEXT_LOCATOR, Faq.EIGHTS_QUESTION_TEXT},

        };
    }
    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }
    @Test
    public void faqSectionTest() {
        driver.get(Faq.URL_SAMOKAT);

        Faq objFaq = new Faq(driver);

        objFaq.findFaqSection();

        objFaq.acceptCookieClick();

        String actual = objFaq.getQuestionText(questionToOpen, locatorFaqQuestion);

        String expected = expectedQuesitonTextFaq;

        assertEquals(expected, actual);

    }
    @After
    public void cleanUpImportantWindows() {
        driver.quit();
    }
}
