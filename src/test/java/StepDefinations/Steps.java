package StepDefinations;

import PageObjects.AddcustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerpage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass{
    @Before
    public void setup() throws IOException {
        //Reading congig.properties file
        configPop= new Properties();
        FileInputStream configprofile=new FileInputStream("config.properties");
        configPop.load(configprofile);
        String br=configPop.getProperty("browser");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configPop.getProperty("chromepath"));
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else if(br.equals("edge")){
            System.setProperty("webdriver.edge.driver", configPop.getProperty("edgepath"));
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }else{
            System.out.println("No driver found");
        }

        driver.manage().window().maximize();
    }

    @Given("user Launch Chrome browser")
    public void user_launch_chrome_browser() {

        lp=new LoginPage(driver);

    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);

    }
    @When("User enters Email as {string} and User Enters Password as {string}")
    public void user_enters_email_as_and_user_enters_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }


    @When("click on Login")
    public void click_on_login() {
        lp.setLogin();

    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsucessfull")){
            driver.close();
            Assert.assertTrue(false);
        }else
        {
            Assert.assertEquals(title,driver.getTitle());
        }

    }

    @When("User click on log out Link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.setLogout();
        Thread.sleep(3000);

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }
    // Add new customer Page steps
    @Then("user can view Dashboard")
    public void user_can_view_dashboard() {
        addcust= new AddcustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getTitle());

    }
    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addcust.clickOnCustomerMenu();


    }
    @When("click on customer menu Item")
    public void click_on_customer_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addcust.clickOnCustomerMenuItem();

    }
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        addcust.clickOnaddNewButton();
        Thread.sleep(3000);

    }
    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.viewaddpage());

    }

    @When("user enter customer info")
    public void user_enter_customer_info() {
        String email=randomString()+"@gmail.com";
        addcust.setEmail(email);
        addcust.setPassword();
        addcust.customerRoles();
        addcust.FirstName();
        addcust.LastName();
        addcust.gender();
        addcust.dateofBirth();
        addcust.comanyName();
        addcust.manageVendor();
        addcust.admincomment();


    }
    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
        addcust.savedetails();
        Thread.sleep(3000);

    }
    @Then("User can view  confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
        .contains("The new customer has been added successfully."));

    }
    // Searching a customer by Email
    @When("Enter Customer EmailID")
    public void enter_customer_email_id() {
        searchcustomer = new SearchCustomerpage(driver);
        searchcustomer.enteremail();
        searchcustomer.enterfirstName();
        searchcustomer.enterlastName();


    }
    @When("Click on Search button")
    public void click_on_search_button() {
        searchcustomer.clickOnSearch();


    }
    @Then("User should found email in the search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status=searchcustomer.checkemailfoundornot();
        Assert.assertEquals(true,status);

    }



}
