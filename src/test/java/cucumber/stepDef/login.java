package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class login {
    WebDriver driver;
    String Baseurl = "https://www.saucedemo.com/";

    @Given("User masuk ke alamat aplikasi")
    public void userMasukKeAlamatAplikasi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Baseurl);
        String loginpageassert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginpageassert,"Swag Labs");
    }

    @When("User input username yang sesuai")
    public void userInputUsernameYangSesuai() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.id("user-name"));
        element.click();
        element.sendKeys("standard_user");
    }

    @And("User input password yang sesuai")
    public void userInputPasswordYangSesuai() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element2 = driver.findElement(By.id("password"));
        element2.click();
        element2.sendKeys("secret_sauce");
    }

    @And("User klik tombol Login")
    public void userKlikTombolLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.isDisplayed();
        element1.click();
    }

    @Then("User melihat menu produk")
    public void userMelihatMenuProduk() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String productpageassert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productpageassert,"Products");
    }

    @And("User input password yang tidak sesuai")
    public void userInputPasswordYangTidakSesuai() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element2 = driver.findElement(By.id("password"));
        element2.click();
        element2.sendKeys("secret");
    }

    @Then("User melihat error")
    public void userMelihatError() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
    }
}

