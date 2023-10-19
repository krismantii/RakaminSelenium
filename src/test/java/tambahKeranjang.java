import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tambahKeranjang {

    @Test
    public void checkout(){
        WebDriver driver;
        String baseurl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        String title = driver.getTitle();
        System.out.println(title);

        //input username
        WebElement element = driver.findElement(By.id("user-name"));
        element.click();
        element.sendKeys("standard_user");
        element.getText();

        //input password
        WebElement element2 = driver.findElement(By.id("password"));
        element2.click();
        element2.sendKeys("secret_sauce");
        element2.getText();

        //klik button login
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.isDisplayed();
        element1.click();

        //klik tambah product
        WebElement element3 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        element3.isDisplayed();
        element3.click();

        //klik keranjang
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        element5.isDisplayed();
        element5.click();

        //klik checkout
        WebElement element6 = driver.findElement(By.id("checkout"));
        element6.isDisplayed();
        element6.click();

        //input first name
        WebElement element7 = driver.findElement(By.id("first-name"));
        element7.click();
        element7.sendKeys("maya");
        element7.getText();

        //input last name
        WebElement element8 = driver.findElement(By.id("last-name"));
        element8.click();
        element8.sendKeys("maharani");
        element8.getText();

        //input last name
        WebElement element9 = driver.findElement(By.id("postal-code"));
        element9.click();
        element9.sendKeys("76476");
        element9.getText();

        //continue
        WebElement element10 = driver.findElement(By.id("continue"));
        element10.click();
        WebElement element11 = driver.findElement(By.id("finish"));
        element11.click();
//       driver.close();
    }

}
