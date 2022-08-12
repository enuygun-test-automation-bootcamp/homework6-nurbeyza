import framework.ConfigReader;
import framework.DriverSetup;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class registerTest {
    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    String savedWishTitle = "";
    @BeforeClass
    public void setup(){
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new HomePage(driver);
        registerPage= new RegisterPage(driver);
    }



    @Test(priority = 1)
    public void openRegister() throws InterruptedException {
        registerPage.openRegisterPage();

    }

    //bilgileri ekleyip kontrol sağlıyoruz
    @Test(priority = 2)
    public void addregisterInfo() throws InterruptedException {
        registerPage.addRegisterinfo("Beyza", "beyza4@gmail.com", "12345678", "12345678");
        Thread.sleep(2000);
        Assert.assertEquals(registerPage.registerClick(), "Wishlist");
    }



}
