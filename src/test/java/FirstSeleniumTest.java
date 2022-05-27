import org.checkerframework.checker.units.qual.g;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
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
    public void findEmailFieldTest() {
//        WebElement element = driver.findElement(By.id("email"));
//        WebElement element = driver.findElement(By.name("email"));
//        WebElement element = driver.findElement(By.linkText("Create a Page"));
//        WebElement element = driver.findElement(By.partialLinkText("a Page"));
//        WebElement element = driver.findElement(By.cssSelector("#email"));
//        WebElement element = driver.findElement(By.className("inputtext"));
        List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementsByXpathTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        WebElement forgotPasswordElement = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
        assertNotNull(forgotPasswordElement);
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
    }

    @Test
    public void loginScreenTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("Kungurovadasha@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("Kungurovadasha@gmail.com", emailValue);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("123456");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("123456", passValue);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
    }

    @Test
    public void findElementsByXpathSignUpButton() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement firstnameElement = driver.findElement(By.xpath("//input[@data-type='text']"));
        assertNotNull(firstnameElement);
        WebElement lastnameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastnameElement);
        WebElement mobNumOrEmailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumOrEmailElement);
        WebElement newPasswordElement = driver.findElement(By.xpath("//input[@data-type='password']"));
        assertNotNull(newPasswordElement);
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButton);
        signUpButton.click();
    }

    @Test
    public void accountCreatePageButton() {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
    }

    @Test
    public void longTextTestFirstName() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement firstnameElement = driver.findElement(By.xpath("//input[@data-type='text']"));
        assertNotNull(firstnameElement);
        firstnameElement.sendKeys("fdsfgdfhbdghfghghgfn");
        String firstnameValue = firstnameElement.getAttribute("value");
        assertEquals("fdsfgdfhbdghfghghgfn", firstnameValue);
    }

    @Test
    public void longTextTestLastName() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement lastnameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastnameElement);
        lastnameElement.sendKeys("hfgnghnhgnbhnbn");
        String lastnameValue = lastnameElement.getAttribute("value");
        assertEquals("hfgnghnhgnbhnbn", lastnameValue);
    }

    @Test
    public void longTextMobEmail() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement mobNumOrEmailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumOrEmailElement);
        mobNumOrEmailElement.sendKeys("gfhgfhgjghjhjjjjfdsfdfd");
        String mobNumOrEmailValue = mobNumOrEmailElement.getAttribute("value");
        assertEquals("gfhgfhgjghjhjjjjfdsfdfd", mobNumOrEmailValue);
    }

    @Test
    public void longTextNewPassword() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement newPasswordElement = driver.findElement(By.xpath("//input[@data-type='password']"));
        assertNotNull(newPasswordElement);
        newPasswordElement.sendKeys("gdhgfjhgjhgwsqkjeiwkrjrk");
        String newPasswordValue = newPasswordElement.getAttribute("value");
        assertEquals("gfhgfhgjghjhjjjjfdsfdfd", newPasswordValue);
    }

    @Test
    public void specialCharTestFirstName() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement firstnameElement = driver.findElement(By.xpath("//input[@data-type='text']"));
        assertNotNull(firstnameElement);
        firstnameElement.sendKeys("!@#$%^");
        String firstnameValue = firstnameElement.getAttribute("value");
        assertEquals("!@#$%^", firstnameValue);
    }

    @Test
    public void specialCharTestLastName() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement lastnameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastnameElement);
        lastnameElement.sendKeys("%^&**((");
        String lastnameValue = lastnameElement.getAttribute("value");
        assertEquals("%^&**((", lastnameValue);
    }

    @Test
    public void specialCharMobEmail() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement mobNumOrEmailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumOrEmailElement);
        mobNumOrEmailElement.sendKeys("*&^$!#%^");
        String mobNumOrEmailValue = mobNumOrEmailElement.getAttribute("value");
        assertEquals("*&^$!#%^", mobNumOrEmailValue);
    }

    @Test
    public void specialChartNewPassword() throws InterruptedException {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement newPasswordElement = driver.findElement(By.xpath("//input[@data-type='password']"));
        assertNotNull(newPasswordElement);
        newPasswordElement.sendKeys("%^&*()!#$%^&&*");
        String newPasswordValue = newPasswordElement.getAttribute("value");
        assertEquals("%^&*()!#$%^&&*", newPasswordValue);
    }

    //  Я нашла эту статью и попробовала метод от туда  https://www.browserstack.com/guide/selenium-wait-for-page-to-load :)

//    @Test
//    public void monthFieldTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement monthDropList = driver.findElement(By.id("month"));
//        monthDropList.click();
//    }
//
//    @Test
//    public void dayFieldTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement dayDropList = driver.findElement(By.id("day"));
//        dayDropList.click();
//    }
//
//    @Test
//    public void yearFieldTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement yearDropList = driver.findElement(By.id("year"));
//        yearDropList.click();
//    }
//

//    @Test
//    public void genderFieldFemaleTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement femaleButton = driver.findElement(By.xpath("//label[text()='Female']"));
//        femaleButton.click();
//    }
//
//    @Test
//    public void genderFieldMaleTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement maleButton = driver.findElement(By.xpath("//label[text()='Male']"));
//        maleButton.click();
//    }
//
//    @Test
//    public void customFieldMaleTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.xpath("//*[text()='Create new account']"));
//        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
//        assertNotNull(createNewAccButton);
//        createNewAccButton.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement customButton = driver.findElement(By.xpath("//label[text()='Custom']"));
//        customButton.click();
//    }

    @Test
    public void signUpTest() {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    }

    @Test
    public void gendersTest() throws InterruptedException {
        String femaleXpath = "//*[@name='sex' and @value=1]";
        String maleXpath = "//*[@name='sex' and @value=2]";

        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));

        Thread.sleep(1000);

        //Verify female gender is checked
        WebElement femaleButton = driver.findElement(By.xpath(femaleXpath));
        femaleButton.click();
        String isFemaleChecked = driver.findElement(By.xpath(femaleXpath)).getAttribute("checked");
        assertNotNull(isFemaleChecked);
        assertEquals("true", isFemaleChecked);

        //Verify male gender is checked
        WebElement maleButton = driver.findElement(By.xpath(maleXpath));
        maleButton.click();
        String isMaleChecked = driver.findElement(By.xpath(maleXpath)).getAttribute("checked");
        assertNotNull(isMaleChecked);
        assertEquals("true", isMaleChecked);

    }

    @Test
    public void errorMessageTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Mobile number or email']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'to reset')]"));
        assertNotNull(error);
    }

    @Test
    public void yearTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Year']")).click();
        driver.findElement(By.xpath("//*[text()='1990']")).click();
       String yearValue =  driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");
       assertEquals("1990",yearValue);

    }
    @ParameterizedTest
    @ValueSource(strings = {"1905", "1950","2022"})
    public void yearTestParametrized(String yearInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@title='Year']")).click();
        driver.findElement(By.xpath("//*[text()='"+yearInput+"']")).click();
        String yearValue =  driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");
        assertEquals(yearInput,yearValue);
    }
}