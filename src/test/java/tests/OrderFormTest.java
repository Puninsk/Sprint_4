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
public class OrderFormTest {
    private final String username;
    private final String userFamilyname;
    private final String userAddress;
    private final String metroStation;
    private final String userPhone;
    private final String userDateOfOrder;

    static TestData testData = new TestData();

    private WebDriver driver;

    public OrderFormTest(String username, String userFamilyname, String userAddress, String metroStation, String userPhone, String userDateOfOrder) {
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
                {testData.upButtonUsernameFirstVariant, testData.upButtonUserFamilynameFirstVariant, testData.upButtonUserAddressFirstVariant, testData.upButtonMetroStationFirstVariant, testData.upButtonUserPhoneFirstVariant, testData.upButtonUserDateOfOrderFirstVariant},
                {testData.upButtonUsernameSecondVariant, testData.upButtonUserFamilynameSecondVariant, testData.upButtonUserAddressSecondVariant, testData.upButtonMetroStationSecondVariant, testData.upButtonUserPhoneSecondVariant, testData.upButtonUserDateOfOrderSecondVariant},
        };
    }
    @Before
    public void browserSetUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void orderWithUpOrderButton() {

        driver.get(testData.urlSamokat);

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        objMainPageOrder.clickOrderButton();

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