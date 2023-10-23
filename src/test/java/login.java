import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class login {
    @Test
    public  void inputLoginsuccess(){
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

        String productpageassert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productpageassert,"Products");

//        driver.findElement(By.xpath("/contains")).isDisplayed();
//        driver.findElement(By.cssSelector("button")).isDisplayed();

//        driver.close();
    }

    @Test
    public  void inputLoginfailed(){
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

        //input password salah
        WebElement element2 = driver.findElement(By.id("password"));
        element2.click();
        element2.sendKeys("secret");
        element2.getText();

        //klik button login
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.isDisplayed();
        element1.click();

        String error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        System.out.println(error);
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
    }
}
