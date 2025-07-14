import com.shaft.driver.SHAFT;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class manualinvoicetest {

    public SHAFT.GUI.WebDriver driver;
    public SHAFT.TestData.JSON testData;
    DashboardPage dash;
    Loginpage log;
    public String username;
    public String passsword;
    public String branch;
    public String startinglocation;
    public String destinationlocation;
    public  String jourenymonth;
    public String jourenyyear;
    public String jourenyday;
    public String numberofaults;
    public String airline;
    public String file;
    public String Adultbase;
    public String Adulttax;
    public String adultmarkup;
    public String adultservice;
    public String adultdiscount;
    public String gds;
    public String airlinepnr;
    public String flight;

    @BeforeTest
    public void browserseteup() throws InterruptedException {

        driver=new SHAFT.GUI.WebDriver();
        log=new Loginpage(driver);
        testData =new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\userinfo.json");
        username=testData.getTestData("name");
        passsword=testData.getTestData("password");
        log.LoginWithValidData(username,passsword);
        dash=new DashboardPage(driver);


    }


  @Test(priority = 0)
    public void manualinvoicewithvalid() throws InterruptedException, AWTException, IOException {

      dash.openDashBard();
      dash.openManualInvoicePage();

     testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\validmanualinvoiceinfo.json");
     branch=testData.getTestData("branchname");
     startinglocation=testData.getTestData("source");
     destinationlocation=testData.getTestData("destination");
     jourenymonth=testData.getTestData("travelmonth");
     jourenyyear=testData.getTestData("travelyear");
     jourenyday=testData.getTestData("travelday");
     numberofaults=testData.getTestData("numberofaults");
     airline=testData.getTestData("airlinename");
     file= testData.getTestData("filepath");
     Adultbase= testData.getTestData("Adultbasefare");
     Adulttax= testData.getTestData("Adulttaxfare");
     adultmarkup= testData.getTestData("Adultmarkup");
     adultservice= testData.getTestData("Adultservice");
     adultdiscount= testData.getTestData("Adultdiscount");
     gds=testData.getTestData("gdspnr");
     airlinepnr= testData.getTestData("airlinepnr");
     flight= testData.getTestData("flightno");

      new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();
      String actual=driver.browser().getCurrentURL();
      String expected="http://192.168.1.60:8080/odeysysadmin/flight/passengerDetailManual?isCoreSystem=true";
      Assert.assertEquals(actual,expected);

      log.Logout();




  }








    @Test(priority = 1)

    public void manualinvoicewitinvalidpnrs() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidgdsandpnrmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");



        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        log.Logout();


    }


    @Test(priority = 2)
    public void manualinvoicewithemptyairline() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\emptyairlinemanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");

        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
        System.out.println("the curent ul is "+ actual);
        log.Logout();


    }

    @Test(priority = 3)
    public void manualinvoicewithinvalidairline() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidairlinemanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");

        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();


        String actual=driver.browser().getCurrentURL();
       System.out.println("the curent ul is "+ actual);
        log.Logout();



    }








    @Test(priority = 4)
    public void manualinvoicewithinvalidstartinglocation() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidstartinglocationmanualinvoice.json");
        branch=testData.getTestData("branchname");

        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");

        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation);

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

         TakesScreenshot src=(TakesScreenshot) driver.getDriver();
        File source=src.getScreenshotAs(OutputType.FILE);
        File dest=new File("C:\\Users\\Hatem Mamdouh\\Desktop\\testeeeeeees.png");
        FileUtils.copyFile(source,dest);
        log.Logout();


    }






    @Test(priority = 5)
    public void manualinvoicewithinvaliddestinationlocation() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invaliddestinationlocationmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");

        destinationlocation=testData.getTestData("destination");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation);

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        TakesScreenshot src=(TakesScreenshot) driver.getDriver();
        File source=src.getScreenshotAs(OutputType.FILE);
        File dest=new File("C:\\Users\\Hatem Mamdouh\\Desktop\\testeeeeeeeeeeeeeeee.png");
        FileUtils.copyFile(source,dest);

        log.Logout();


    }



    @Test(priority = 6)
    public void manualinvoicewithinvalidlightnumber() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidflightnumbermanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");

        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();


        String actual=driver.browser().getCurrentURL();
        System.out.println("the curent ul is "+ actual);
        log.Logout();


    }






    @Test(priority = 7)
    public void manualinvoicewithexlsfilepath() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\xlsfilepathmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();


        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        TakesScreenshot src=(TakesScreenshot) driver.getDriver();
        File source=src.getScreenshotAs(OutputType.FILE);
        File dest=new File("C:\\Users\\Hatem Mamdouh\\Desktop\\testeeeeeeeeeee.png");
        FileUtils.copyFile(source,dest);

        log.Logout();


    }


    @Test(priority = 8)
    public void manualinvoicewithejpgfilepath() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\jpgfilepathmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();




        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        TakesScreenshot src=(TakesScreenshot) driver.getDriver();
        File source=src.getScreenshotAs(OutputType.FILE);
        File dest=new File("C:\\Users\\Hatem Mamdouh\\Desktop\\testeeeeeeeeeess.png");
        FileUtils.copyFile(source,dest);

        log.Logout();


    }



    @Test(priority = 9)
    public void manualinvoicewithemptyfaredetails() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\emptyfaredetailsmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();


        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);
        log.Logout();


    }



    @Test(priority = 10)
    public void manualinvoicewwithinvalidfaredetails() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidfaredetailsrmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);
        log.Logout();


    }

    @Test(priority = 11)
    public void manualinvoicewithemptyfilepath() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\emptyfilepathmanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        log.Logout();


    }


    @Test(priority = 12)
    public void manualinvoicewithinvalidbasefare() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\invalidbasefaremanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
        String expected ="http://192.168.1.60:8080/odeysysadmin/flight/flightWidgetManual";
        Assert.assertEquals(actual,expected);

        log.Logout();


    }


    @Test(priority = 13)
    public void manualinvoicewithbasefarehasspace() throws InterruptedException, AWTException, IOException {

        log.LoginWithValidData(username,passsword);
        dash.openDashBard();
        dash.openManualInvoicePage();
        testData=new SHAFT.TestData.JSON("C:\\Users\\Hatem Mamdouh\\Desktop\\New folder\\ndctest\\src\\test\\resources\\spacebasefaremanualinvoice.json");
        branch=testData.getTestData("branchname");
        startinglocation=testData.getTestData("source");
        destinationlocation=testData.getTestData("destination");
        jourenymonth=testData.getTestData("travelmonth");
        jourenyyear=testData.getTestData("travelyear");
        jourenyday=testData.getTestData("travelday");
        numberofaults=testData.getTestData("numberofaults");
        airline=testData.getTestData("airlinename");
        file= testData.getTestData("filepath");
        Adultbase= testData.getTestData("Adultbasefare");
        Adulttax= testData.getTestData("Adulttaxfare");
        adultmarkup= testData.getTestData("Adultmarkup");
        adultservice= testData.getTestData("Adultservice");
        adultdiscount= testData.getTestData("Adultdiscount");
        gds=testData.getTestData("gdspnr");
        airlinepnr= testData.getTestData("airlinepnr");
        flight= testData.getTestData("flightno");


        new manualinvoice(driver).SelectBranch(branch).AddStartingFrom(startinglocation).AddGoingTo(destinationlocation).SelectDateOfJourney(jourenymonth,jourenyyear,jourenyday).SelectNumberOfAdult(Integer.parseInt(numberofaults)).enterairlinename(airline).DOC(file).enterbasefare(Adultbase).entertaxfare(Adulttax).entermarkup(adultmarkup).enterservice(adultservice).enterdiscount(adultdiscount).entergdspnr(gds).enterairlinepnr(airlinepnr).enterflightno(flight).addtravller();

        String actual=driver.browser().getCurrentURL();
       System.out.println("the current url is "+actual);

        log.Logout();


    }





}
