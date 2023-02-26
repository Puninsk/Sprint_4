package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillOrderFormPageOne {
    private WebDriver driver;
    private By nameInput = By.cssSelector("Input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");

    private By familyameInput = By.cssSelector("Input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Фамилия']");

    private By addressInput = By.cssSelector("Input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']");

    private By metroInput = By.cssSelector(".select-search__value .select-search__input");
    private By metroStationButton = By.xpath("//*[@data-index=\"1\"]");


    private By phoneNumber = By.cssSelector("Input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']");

    private By buttonToPageTwoOrderFrom = By.cssSelector(".Order_NextButton__1_rCA .Button_Button__ra12g.Button_Middle__1CSJM");

    public FillOrderFormPageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(nameInput).sendKeys(username);
    }

    public void setUserFamilyname(String userFamilyname) {
        driver.findElement(familyameInput).sendKeys(userFamilyname);
    }

    public void setUserAddress(String userAddress) {
        driver.findElement(addressInput).sendKeys(userAddress);
    }
    public void setUserPhone(String userPhone) {
        driver.findElement(phoneNumber).sendKeys(userPhone);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(metroInput).sendKeys(metroStation);
        driver.findElement(metroStationButton).click();
    }
    public void fillOrderFormPageOne(String username, String userFamilyname, String userAddress, String metroStation, String userPhone) {
        setUsername(username);
        setUserFamilyname(userFamilyname);
        setUserAddress(userAddress);
        setMetroStation(metroStation);
        setUserPhone(userPhone);
    }
    public void waitForPage() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(nameInput));
    }
    public void waitForButtonToPageTwo() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonToPageTwoOrderFrom));
    }
    public void clickButtonToPageTwoOrderFrom() {
        driver.findElement(buttonToPageTwoOrderFrom).click();
    }

}
