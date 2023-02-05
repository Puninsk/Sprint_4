package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillOrderFormPageOne {
        private WebDriver driver;

        private By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
        private By familyameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

        private By addressInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
        private By metroStationButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button/div[2]");

        private By metroInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");
        private By phoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
        private By buttonToPageTwoOrderFrom = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

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
            Assert.assertTrue(driver.findElement(nameInput).isEnabled());
        }

        public void waitForButtonToPageTwo() {
            Assert.assertTrue(driver.findElement(buttonToPageTwoOrderFrom).isEnabled());
        }

        public void clickButtonToPageTwoOrderFrom() {
            driver.findElement(buttonToPageTwoOrderFrom).click();
        }

    }

