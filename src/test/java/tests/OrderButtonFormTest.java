package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.*;

@RunWith(Parameterized.class)
public class OrderButtonFormTest {
    private final String username;
    private final String userFamilyname;
    private final String userAddress;
    private final String metroStation;
    private final String userPhone;
    private final String orderButton;

    private final String userDateOfOrder;

    private WebDriver driver;


    public OrderButtonFormTest(String orderButton, String username, String userFamilyname, String userAddress, String metroStation, String userPhone, String userDateOfOrder) {
        this.orderButton = orderButton;
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
                {MainPageOrder.BUTTON_ORDER_DOWN, TestData.DOWN_BUTTON_USERNAME_FIRST_VARIANT, TestData.DOWN_BUTTON_FAMILYNAME_FIRST_VARIANT, TestData.DOWN_BUTTON_ADDRESS_FIRST_VARIANT,
                        TestData.DOWN_BUTTON_STATION_FIRST_VARIANT, TestData.DOWN_BUTTON_PHONE_FIRST_VARIANT, TestData.DOWN_BUTTON_DATE_OF_ORDER_FIRST_VARIANT},
                {MainPageOrder.BUTTON_ORDER_DOWN, TestData.DOWN_BUTTON_USERNAME_SECOND_VARIANT, TestData.DOWN_BUTTON_FAMILYNAME_SECOND_VARIANT, TestData.DOWN_BUTTON_ADDRESS_SECOND_VARIANT,
                        TestData.DOWN_BUTTON_STATION_SECOND_VARIANT, TestData.DOWN_BUTTON_PHONE_SECOND_VARIANT, TestData.DOWN_BUTTON_DATE_OF_ORDER_SECOND_VARIANT},
                {MainPageOrder.BUTTON_ORDER_UP, TestData.UP_BUTTON_USERNAME_FIRST_VARIANT, TestData.UP_BUTTON_FAMILYNAME_FIRST_VARIANT, TestData.UP_BUTTON_ADDRESS_FIRST_VARIANT,
                        TestData.UP_BUTTON_STATION_FIRST_VARIANT, TestData.UP_BUTTON_PHONE_FIRST_VARIANT, TestData.UP_BUTTON_DATE_OF_ORDER_FIRST_VARIANT},
                {MainPageOrder.BUTTON_ORDER_UP, TestData.UP_BUTTON_USERNAME_SECOND_VARIANT, TestData.UP_BUTTON_FAMILYNAME_SECOND_VARIANT, TestData.UP_BUTTON_ADDRESS_SECOND_VARIANT,
                        TestData.UP_BUTTON_STATION_SECOND_VARIANT, TestData.UP_BUTTON_PHONE_SECOND_VARIANT, TestData.UP_BUTTON_DATE_OF_ORDER_SECOND_VARIANT},

        };
    }
    @Before
    public void browserSetUp() {
       driver = new ChromeDriver();
    }
    @Test
    public void orderWithDownOrderButton() {

        driver.get(MainPageOrder.URL_SAMOKAT);

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        objMainPageOrder.clickOrderButton(orderButton);

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
