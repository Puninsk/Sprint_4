package tests;

import PageObject.FillOrderFormPageOne;
import PageObject.FillOrderFormPageTwo;
import PageObject.MainPageOrder;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestOrderFormDownButton {
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private By buttonOrderDown = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button");

    private WebDriver driver;

    @Test
    public void makeOrder() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objMainPageOrder.waitForOrderButtonDown();

        objMainPageOrder.clickOrderButtonDown();

        FillOrderFormPageOne objFillOrderFormPageOne = new FillOrderFormPageOne(driver);

        objFillOrderFormPageOne.waitForPage();

        objFillOrderFormPageOne.fillOrderFormPageOne("Ник", "Пун", "Серафимовича 2", "Бульвар Рокоссовского","+79034442211");

        objFillOrderFormPageOne.waitForButtonToPageTwo();

        objFillOrderFormPageOne.clickButtonToPageTwoOrderFrom();

        FillOrderFormPageTwo objFillOrderFormPageTwo = new FillOrderFormPageTwo(driver);

        objFillOrderFormPageTwo.waitForPageTwoLoad();

        objFillOrderFormPageTwo.fillOrderFormPageOne("20.02.2023");

        objFillOrderFormPageTwo.waitForButtonOrderPageTwoLoad();

        objFillOrderFormPageTwo.clickButtonOrderPageTwo();

    }


    @After
    public void cleanUp() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void makeOrderNewData() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objMainPageOrder.waitForOrderButtonDown();

        objMainPageOrder.clickOrderButtonDown();

        FillOrderFormPageOne objFillOrderFormPageOne = new FillOrderFormPageOne(driver);

        objFillOrderFormPageOne.waitForPage();

        objFillOrderFormPageOne.fillOrderFormPageOne("Андрей", "Терещен", "Арбат 43", "Бульвар Рокоссовского","+79036567901");

        objFillOrderFormPageOne.waitForButtonToPageTwo();

        objFillOrderFormPageOne.clickButtonToPageTwoOrderFrom();

        FillOrderFormPageTwo objFillOrderFormPageTwo = new FillOrderFormPageTwo(driver);

        objFillOrderFormPageTwo.waitForPageTwoLoad();

        objFillOrderFormPageTwo.fillOrderFormPageOne("31.06.2023");

        objFillOrderFormPageTwo.waitForButtonOrderPageTwoLoad();

        objFillOrderFormPageTwo.clickButtonOrderPageTwo();

    }


    @After
    public void cleanUpNewData() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }
}
