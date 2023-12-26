package StepDefinations;

import PageObjects.AddcustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerpage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddcustomerPage addcust;
    public SearchCustomerpage searchcustomer;
    public Properties configPop;
//Creating random string for emailid
    public static String randomString(){
        String generatedString1= RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
}
