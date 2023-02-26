package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

@RunWith(Parameterized.class)
public class OrderDownButtonFormTest {
    private final String username;
    private final String userFamilyname;
    private final String userAddress;
    private final String metroStation;
    private final String userPhone;

    private final String userDateOfOrder;

    private WebDriver driver;

    static TestData testData = new TestData();

    public OrderDownButtonFormTest(String username, String userFamilyname, String userAddress, String metroStation, String userPhone, String userDateOfOrder) {
        this.username = username;
        this.userFamilyname = userFamilyname;
        this.userAddress = userAddress;
        this.metroStation = metroStation;
        this.userPhone = userPhone;
        this.userDateOfOrder = userDateOfOrder;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {testData.DownButtonUsernameFirstVariant, testData.DownButtonUserFamilynameFirstVariant, testData.DownButtonUserAddressFirstVariant, testData.DownButtonMetroStationFirstVariant, testData.DownButtonUserPhoneFirstVariant, testData.DownButtonUserDateOfOrderFirstVariant},
                {testData.DownButtonUsernameSecondVariant, testData.DownButtonUserFamilynameSecondVariant, testData.DownButtonUserAddressSecondVariant, testData.DownButtonMetroStationSecondVariant, testData.DownButtonUserPhoneSecondVariant, testData.DownButtonUserDateOfOrderSecondVariant},
        };
    }
    @Before
    public void browserSetUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void orderWithDownOrderButton() {

        driver.get(testData.urlSamokat);

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        objMainPageOrder.findButtonOrderDown();

        objMainPageOrder.waitForOrderButtonDown();

        objMainPageOrder.clickOrderButtonDown();

        FillOrderFormPageOne objFillOrderFormPageOne = new FillOrderFormPageOne(driver);

        objFillOrderFormPageOne.waitForPage();

        objFillOrderFormPageOne.fillOrderFormPageOne(username, userFamilyname, userAddress, metroStation, userPhone);

        objFillOrderFormPageOne.waitForButtonToPageTwo();

        objFillOrderFormPageOne.clickButtonToPageTwoOrderFrom();

        FillOrderFormPageTwo objFillOrderFormPageTwo = new FillOrderFormPageTwo(driver);

        objFillOrderFormPageTwo.waitForPageTwoLoad();

        objFillOrderFormPageTwo.fillOrderFormPageOne(userDateOfOrder);

        objFillOrderFormPageTwo.waitForButtonOrderPageTwoLoad();

        objFillOrderFormPageTwo.clickButtonOrderPageTwo();

        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);

        objConfirmationWindow.waitForOrderConfirmationButton();

        objConfirmationWindow.clickorderConfirmationButton();

        OrderCreatedWindow objOrderCreatedWindow = new OrderCreatedWindow(driver);

        objOrderCreatedWindow.waitForOrderConfirmationButton();
    }
    @After
    public void cleanUpNewDataUp() {
        driver.quit();
    }
}
