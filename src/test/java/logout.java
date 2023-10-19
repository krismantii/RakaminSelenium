import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class logout {
    @Test
    public void logOut(){
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

        //klik tombol logout
        WebElement element3 = driver.findElement(By.id("react-burger-menu-btn"));
        element3.isDisplayed();
        element3.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        element5.isDisplayed();
        element5.click();
    }
}
