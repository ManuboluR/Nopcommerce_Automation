package PageObjects;
import Utilities.contetnts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage extends contetnts {
    public WebDriver driver;
    public contetnts ct;

    public AddcustomerPage(WebDriver rdriver){
        driver=rdriver;
        PageFactory.initElements(rdriver,this);

    }
    @FindBy(xpath="//a[@class='nav-link']/i[@class='nav-icon far fa-user']")
    WebElement linkcustomers_menu;
    @FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
    WebElement linkcustomers_menuItem;
    @FindBy(xpath="//a[@class='btn btn-primary']")
    WebElement addNewbtn;
    @FindBy(id="Email")
    WebElement textEmail;
    @FindBy(id="Password")
    WebElement txtpassword;
    @FindBy(id="FirstName")
    WebElement txtFirstName;
    @FindBy(id="LastName")
    WebElement txtLatName;
    @FindBy(xpath="//input[@id='Gender_Male']")
    WebElement radioMale;
    @FindBy(xpath="//input[@id='Gender_Female']")
    WebElement radioFemale;
    @FindBy(xpath="//input[@id='DateOfBirth']")
    WebElement dateOfBorth;
    @FindBy(xpath="//input[@id='Company']")
    WebElement companyName;
    @FindBy(id="AdminComment")
    WebElement txtadminContent;
    @FindBy(xpath="//button[@name='save']")
    WebElement btnSave;
    @FindBy(xpath="//input[@aria-labelledby='SelectedCustomerRoleIds_label']")
    WebElement customerroles;
    @FindBy(xpath="//li[contains(text(),'Administrators')]")
    WebElement lisadministaror;
    @FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
    WebElement lisForummoderators;
    @FindBy(xpath="//li[contains(text(),'Guests')]")
    WebElement lisguests;
    @FindBy(xpath="//li[contains(text(),'Registered')]")
    WebElement lisregistered;
    @FindBy(xpath="//li[contains(text(),'Vendors')]")
    WebElement lisvendors;
    @FindBy(xpath="//select[@id='VendorId']")
    WebElement managevendorId;

    /*By textEmail=By.xpath("//input[@id='Email']");
    By txtpassword=By.xpath("//input[@id='Password']");
    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLatName=By.xpath("//input[@id='LastName']");
    By radioMale=By.xpath("//input[@id='Gender_Male']");
    By radioFemale=By.xpath("Gender_Female");
    By dateOfBorth=By.xpath("//input[@id='DateOfBirth']");
    By companyName=By.xpath("//input[@id='Company']");
    By txtadminContent=By.xpath("//input[@id='AdminComment']");
    By btnSave=By.xpath("//button[@name='save']");
    By customerroles=By.xpath("//input[@aria-labelledby='SelectedCustomerRoleIds_label']");
    By lisadministaror=By.xpath("//li[contains(text(),'Administrators')]");
    By lisForummoderators=By.xpath("//li[contains(text(),'Forum Moderators')]");
    By lisguests=By.xpath("//li[contains(text(),'Guests')]");
    By lisregistered=By.xpath("//li[contains(text(),'Registered')]");
    By lisvendors=By.xpath("//li[contains(text(),'Vendors')]");
    By managevendorId=By.xpath("//select[@id='VendorId']");  */




    public String getTitle() {
        return driver.getTitle();
    }
    public void clickOnCustomerMenu() {
        linkcustomers_menu.click();
    }
    public void clickOnCustomerMenuItem() {
        linkcustomers_menuItem.click();
    }
    public void clickOnaddNewButton() {
        addNewbtn.click();
    }
    public String viewaddpage() {
        return driver.getTitle();
    }
    public void setEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void setPassword() {
        txtpassword.sendKeys(ct.password);
    }

    public void customerRoles() {
        customerroles.clear();
        customerroles.click();
        lisadministaror.click();
    }

    public void FirstName() {
        txtFirstName.sendKeys(ct.addcustompageFirstName);
    }

    public void LastName() {
        txtLatName.sendKeys(ct.addcustompageLastName);
    }

    public void gender() {
        radioMale.click();
    }

    public void dateofBirth() {
        dateOfBorth.sendKeys(ct.addcustompagedateofBirth);
    }

    public void comanyName() {
        companyName.sendKeys(ct.addcustompageCompanyName);
    }

    public void manageVendor() {
        Select s= new Select(managevendorId);
        s.selectByVisibleText("Vendor 1");
    }

    public void admincomment() {
        txtadminContent.sendKeys(ct.addcustompageadmincomments);
    }

    public void savedetails() {
        btnSave.click();
    }
}
