import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.python.antlr.ast.Str;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class manualinvoice extends Loginpage{

    By BranchList = By.xpath("//select[@id='branchListId']");
    By StartingFrom = By.xpath("//input[@id='startingFrom_1']");
    By GoingTo = By.xpath("//input[@id='goingTo_1']");
    By DataPicker = By.id("datePicker_1");
    By noOfAdults = By.id("noOfAdults");
    By airline=By.xpath("//input[@id='preffered']");
    By doc=By.xpath("//input[@id='uploadBtn']");
    By brow=By.xpath("//form[@id='flightWidgetFormOneWay']//div[@class='uploadBtn']");
    By adultbase=By.xpath("//input[@id='adultbasefare']");
    By adulttax=By.xpath("//input[@id='adulttax']");
    By adultmarkup=By.xpath("//input[@id='adultMarkup']");
    By adultservice=By.xpath("//input[@id='adultServiceCharge']");
    By adultdiscount=By.xpath("//input[@id='adultDiscount']");
    By gdspnr=By.xpath("//input[@id='gdsPNR']");
    By airlineonr=By.xpath("//input[@id='airLinePNR']");
    By flightno=By.xpath("//input[@id='flightNo']");
    By addtraveller = By.xpath("//form[@id='flightWidgetFormOneWay']//input[@value='ADD Traveller']");


    public manualinvoice(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }


   public manualinvoice  SelectBranch(String Branch) {
        driver.element().select(BranchList, Branch);
        return new manualinvoice(driver);
    }


    public manualinvoice AddStartingFrom(String Place) throws InterruptedException{
      //driver.element().click(StartingFrom);
//        driver.element().type(StartingFrom, Place).select(StartingFrom, Place);
        driver.element().click(StartingFrom);
        driver.element().type(StartingFrom, Place);
        Thread.sleep(300);
        driver.element().keyPress(StartingFrom,Keys.ENTER);
       // By source = By.xpath("//div[contains(@title,'"+Place+" -')]");
      //  driver.element().type(StartingFrom, Place).waitToBeReady(source).keyPress(StartingFrom, Keys.ENTER);

        return new manualinvoice(driver);
    }

    public manualinvoice AddGoingTo(String Place) throws InterruptedException {
        driver.element().click(GoingTo);
        driver.element().type(GoingTo, Place);
        Thread.sleep(300);
        driver.element().keyPress(GoingTo,Keys.ENTER);
        return new manualinvoice(driver);
    }

    public manualinvoice SelectDateOfJourney(String Months, String Year, String Day) {
        driver.element().click(DataPicker);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-year']"), Year);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-month']"), Months);
        driver.element().click(By.xpath("//a[contains(@class, 'ui-state-default') and text()='" + Day + "']"));

        return new manualinvoice(driver);
    }

    public manualinvoice SelectNumberOfAdult(int Number) {
        driver.element().select(noOfAdults, String.valueOf(Number));
        return new manualinvoice(driver);
    }

    public manualinvoice enterairlinename(String airlinename) throws AWTException {
        driver.element().click(airline);
        driver.element().type(airline, airlinename);
        driver.getDriver().findElement(airline).sendKeys(Keys.ENTER);

        return new manualinvoice(driver);
    }

    public manualinvoice DOC(String filePath) throws AWTException {
        driver.element().click(brow);

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        robot.delay(1000);

        // CTRL + V to paste
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        return new manualinvoice(driver);
    }

    public manualinvoice enterbasefare(String adultbasefare){
        driver.element().type(adultbase,adultbasefare);
        return new manualinvoice(driver);
    }
    public manualinvoice entertaxfare(String adulttaxfare){
        driver.element().type(adulttax,adulttaxfare);
        return new manualinvoice(driver);
    }
    public manualinvoice entermarkup(String adultmarkupvalue){
        driver.element().type(adultmarkup,adultmarkupvalue);
        return new manualinvoice(driver);
    }
    public manualinvoice enterservice(String adultservicevalue){
        driver.element().type(adultservice,adultservicevalue);
        return new manualinvoice(driver);
    }
    public manualinvoice enterdiscount(String adultdiscountvalue){
        driver.element().type(adultdiscount,adultdiscountvalue);
        return new manualinvoice(driver);
    }

    public manualinvoice entergdspnr(String gdspnrvalue){
        driver.element().type(gdspnr,gdspnrvalue);
        return new manualinvoice(driver);
    }

    public manualinvoice enterairlinepnr(String airlinepnrvalue){
        driver.element().type(airlineonr,airlinepnrvalue);
        return new manualinvoice(driver);
    }
    public manualinvoice enterflightno(String flightvalue){
        driver.element().type(flightno, flightvalue);
        return new manualinvoice(driver);
    }
    public manualinvoice addtravller(){
        driver.element().click(addtraveller);
        return new manualinvoice(driver);
    }

}

