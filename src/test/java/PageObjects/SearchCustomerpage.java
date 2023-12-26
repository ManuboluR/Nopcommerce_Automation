package PageObjects;

import Utilities.WaitHelper;
import Utilities.contetnts;
import org.bouncycastle.pqc.crypto.ntru.NTRUKEMExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerpage {
    public WebDriver driver;
    WaitHelper waitHelper;
    contetnts ct;

    public SearchCustomerpage(WebDriver rdriver){
        driver=rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper = new WaitHelper(driver);
    }
    @FindBy(id="SearchEmail")
    WebElement txtsearchEmaill;
    @FindBy(id="SearchFirstName")
    WebElement txtSearchFirstName;
    @FindBy(id = "SearchLastName")
    WebElement txtSearchLastName;
    @FindBy(id="search-customers")
    WebElement btnsearchcustomers;
    @FindBy(id="customers-grid")
    WebElement table;
    @FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
    List<WebElement> rows;
    @FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> columns;

    public void enteremail() {
        waitHelper.WaitForElement(txtsearchEmaill);
        txtsearchEmaill.sendKeys(ct.searchEmail);
    }

    public void enterfirstName() {
        waitHelper.WaitForElement(txtSearchFirstName);
        txtSearchFirstName.sendKeys(ct.searcfirstName);
    }

    public void enterlastName() {
        waitHelper.WaitForElement(txtSearchLastName);
        txtSearchLastName.sendKeys(ct.searcLatName);
    }

    public void clickOnSearch() {
        waitHelper.WaitForElement(btnsearchcustomers);
        btnsearchcustomers.click();
    }
    public int getrows(){
        return(rows.size());
    }
    public int getcolumns(){
        return(columns.size());
    }

    public boolean checkemailfoundornot() {
        boolean flag=false;
        for(int i=1;i<=getrows();i++){
            String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailid);
            if(emailid.equals(ct.searchEmail)){
                flag=true;
            }

        }
        return flag;

    }
}
