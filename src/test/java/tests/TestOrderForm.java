package tests;

import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.FillOrderFormPageOne;
import PageObject.MainPageOrder;
import PageObject.FillOrderFormPageTwo;

public class TestOrderForm {
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    private WebDriver driver;

    @Test
    public void makeOrder() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        objMainPageOrder.clickOrderButton();

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
    public void makeOrderNewDataUp() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageOrder objMainPageOrder = new MainPageOrder(driver);

        objMainPageOrder.clickOrderButton();

        FillOrderFormPageOne objFillOrderFormPageOne = new FillOrderFormPageOne(driver);

        objFillOrderFormPageOne.waitForPage();

        objFillOrderFormPageOne.fillOrderFormPageOne("Таня", "Александрова", "ул. Большая Никитская, дом 3", "Бульвар Рокоссовского","+79165342571");

        objFillOrderFormPageOne.waitForButtonToPageTwo();

        objFillOrderFormPageOne.clickButtonToPageTwoOrderFrom();

        FillOrderFormPageTwo objFillOrderFormPageTwo = new FillOrderFormPageTwo(driver);

        objFillOrderFormPageTwo.waitForPageTwoLoad();

        objFillOrderFormPageTwo.fillOrderFormPageOne("01.04.2024");

        objFillOrderFormPageTwo.waitForButtonOrderPageTwoLoad();

        objFillOrderFormPageTwo.clickButtonOrderPageTwo();

    }


    @After
    public void cleanUpNewDataUp() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }
}
