package cucumber.stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tambahProduk {
    @cucumber.api.java.en.Given("User berada di halaman produk")
    public void userBeradaDiHalamanProduk() {
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String productpageassert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productpageassert,"Products");
    }

    @cucumber.api.java.en.When("User klik tombol add to cart")
    public void userKlikTombolAddToCart() {
        //klik tambah product
        WebElement element11 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        element11.isDisplayed();
        element11.click();
    }

    @cucumber.api.java.en.Then("User klik icon keranjang")
    public void userKlikIconKeranjang() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        element5.isDisplayed();
        element5.click();
    }

    @cucumber.api.java.en.And("User melihat menu keranjang")
    public void userMelihatMenuKeranjang() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String product = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(product,"Sauce Labs Backpack");
    }
}
