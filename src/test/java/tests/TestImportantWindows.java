package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.ImportantWindows;

public class TestImportantWindows {

    private WebDriver driver;
    private By firstImportantWindow = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private By importantThings = By.xpath("//*[@id=\"accordion__heading-7\"]");
    @Test
    public void checkImportantWindows() {

        System.setProperty("webdriver.chrome.driver","/Users/nikitapuninskiy/WebDriver/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        ImportantWindows objImportantWindows = new ImportantWindows(driver);

        WebElement element = driver.findElement(importantThings);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objImportantWindows.waitForPage();

        objImportantWindows.clickImportantWindows();
    }

}
