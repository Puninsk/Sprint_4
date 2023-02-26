package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Faq;
import pageObject.TestData;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqSectionTest {
    private WebDriver driver;

    private final String expectedQuesitonTextFaq;

    private final String locatorFaqQuestion;

    private final String questionToOpen;

    static TestData testData = new TestData();

    public FaqSectionTest(String questionToOpen, String locatorFaqQuestion, String expectedQuesitonTextFaq) {
        this.questionToOpen = questionToOpen;
        this.locatorFaqQuestion = locatorFaqQuestion;
        this.expectedQuesitonTextFaq = expectedQuesitonTextFaq;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionText() {
        return new Object[][]{
                {testData.firstQuestionTitleLocator, testData.firstQuestionTextLocator, testData.firstQuestionText},
                {testData.secondQuestionTitleLocator, testData.secondQuestionTextLocator, testData.secondQuestionText},
                {testData.thirdQuestionTitleLocator, testData.thirdQuestionTextLocator, testData.thirdQuestionText},
                {testData.forthQuestionTitleLocator, testData.forthQuestionTextLocator, testData.forthQuestionText},
                {testData.fifthQuestionTitleLocator, testData.fifthQuestionTextLocator, testData.fifthQuestionText},
                {testData.sixthQuestionTitleLocator, testData.sixthQuestionTextLocator, testData.sixthQuestionText},
                {testData.seventhQuestionTitleLocator, testData.seventhQuestionTextLocator, testData.seventhQuestionText},
                {testData.eightsQuestionTitleLocator, testData.eightsQuestionTextLocator, testData.eightsQuestionText},

        };
    }

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }
    @Test
    public void FaqSectionTest() {


        driver.get(testData.urlSamokat);

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
