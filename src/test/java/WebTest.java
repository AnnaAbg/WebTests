import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {
    // Test Case:
    // 1. Open the page "http://www.99-bottles-of-beer.net/"
    // 2. Click on menu "Browse languages"
    // 3. Click on menu "Start"
    // 4. Verify that user sees the title "Welcome to 99 Bottles of Beer"
    // 5. Close the browser


    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "E:\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id ='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();


        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
}
