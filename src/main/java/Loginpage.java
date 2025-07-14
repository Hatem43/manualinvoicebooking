import com.shaft.driver.SHAFT;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

public class Loginpage {

   public SHAFT.GUI.WebDriver driver;

    public Loginpage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public String ValidUser = "e.saady";
    public String ValidPass = "qqE6)Cxp6>B8";

    public String ValidPassForMb3 = "9YDkEZfw3x6Yeua";
    By usernameele = By.id("id-Username");
    By passwordele = By.id("id-Password");
    By loginbttnele = By.xpath("//span[@class='p-button-label']");
    public By DropDownLogout = By.xpath("//p[@class='drpdwn_usr']");
    public By LogoutButton= By.xpath("//a[contains(text(),'Logout')]");


    public void LoginWithValidData(String username, String password) throws InterruptedException {

        driver.browser().navigateToURL("http://192.168.1.60:8080/odeysysadmin");
        driver.element().type(usernameele, ValidUser);

        if(driver.browser().getCurrentURL().contains("https://mb3.ndceg.com/")){
            driver.element().type(passwordele, ValidPassForMb3);
        }
        else {
            driver.element().type(passwordele, ValidPass);
        }
        Thread.sleep(5000);
//        driver.getDriver().manage().timeouts().implicitlyWait(80000, TimeUnit.SECONDS);
        driver.element().click(loginbttnele);
        Thread.sleep(5000);

    }

    public void Logout(){
        driver.element().click(DropDownLogout).click(LogoutButton);
    }

}
