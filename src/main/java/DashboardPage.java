
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class DashboardPage extends Loginpage {

    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }


    By BookingMidOffice = By.xpath("//a[contains(text(),'Booking-Mid')]");
    By manualInvoice = By.xpath("//a[normalize-space()='Manual Booking Invoice']");
    By dashboardPage = By.xpath("//a[normalize-space()='Dashboard']");



    public void openDashBard() {
        driver.element().click(dashboardPage);
    }

    public void openManualInvoicePage(){
            driver.element().click(BookingMidOffice)
                    .click(manualInvoice);

    }

}
