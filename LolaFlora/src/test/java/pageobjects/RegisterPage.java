package pageobjects;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// register sayfasında bulunan elementleri ve kullanacağım fonksiyonları bu sınıf altında yazdım
public class RegisterPage {
    WebDriver driver;
    Helper elementHelper;

    By wishIcon = By.xpath("//i[@class=\"icon-n-072\"]");
    By wish=By.xpath("//i[@class=\"icon-n-072\"]");
    By accountIcon=By.xpath("//div[@class=\"tt-account tt-dropdown-obj\"]");
    By registerIcon=By.xpath("//a/i[@class=\"icon-f-94 search-icon\"]");
    By nameInput=By.xpath("//input[@id=\"loginInputName\"]");
    By emailInput=By.id("loginInputEmail");
    By passwordInput=By.id("loginInputPassword");
    By againpasswordInput=By.id("loginInputPasswordConfirm");
    By createButon=By.xpath("//button[@class=\"btn \"]");


    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    //register alanını açtığım fonksiyon
    public void openRegisterPage(){
        this.elementHelper.findElement(accountIcon).click();
        this.elementHelper.findElement(registerIcon).click();
        this.elementHelper.findElement(nameInput).click();
    }

    //Bilgileri bu fonksiyonda ekliyoruz
    public void addRegisterinfo(String name, String mail, String password, String confirmPassword){

        this.elementHelper.findElement(nameInput).sendKeys(name);
        this.elementHelper.findElement(emailInput).sendKeys(mail);
        this.elementHelper.findElement(passwordInput).sendKeys(password);
        this.elementHelper.findElement(againpasswordInput).sendKeys(confirmPassword);
        this.elementHelper.findElement(createButon).click();
    }

    //kontrol için yazdığım fonsiyon
    public String registerClick() throws InterruptedException {
        this.elementHelper.findElement(accountIcon).click();
        return this.elementHelper.findElements(wish).get(0).getText();
    }



}
