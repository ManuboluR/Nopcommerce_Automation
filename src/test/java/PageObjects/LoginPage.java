package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;

public LoginPage(WebDriver rdriver){
    driver=rdriver;
    PageFactory.initElements(rdriver,this);

}
@FindBy(id="Email")
    WebElement txtemail;
@FindBy(id="Password")
    WebElement txtPassword;
@FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement btnLogin;
@FindBy(linkText = "Logout")
    WebElement btnLogout;
public void setUserName(String email){
    txtemail.clear();
    txtemail.sendKeys(email);
}
    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void setLogin(){
        btnLogin.click();
    }
    public void setLogout(){
    btnLogout.click();

    }

}
