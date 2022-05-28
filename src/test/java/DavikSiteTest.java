import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class DavikSiteTest {

    private static final String HOME_PAGE_URL = "https://daviktapes.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }
    @AfterAll
    public static void classTearDown() {
        SharedDriver.closeDriver();
    }

    @AfterEach
    public void testTearDown() {
        driver.get(HOME_PAGE_URL);
    }
    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");
    }

    @Test
    public void actionCompanyMenuTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Company']")));
        WebElement element = driver.findElement(By.xpath("//a[text()='Company']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    @Test
    public void actionProductsMenuTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Products']")));
        WebElement element = driver.findElement(By.xpath("//a[text()='Products']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    @Test
    public void actionIndustriesMenuTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Industries']")));
        WebElement element = driver.findElement(By.xpath("//a[text()='Industries']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    @Test
    public void actionKnowledgeCenterMenuTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Knowledge Center']")));
        WebElement element = driver.findElement(By.xpath("//a[text()='Knowledge Center']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}