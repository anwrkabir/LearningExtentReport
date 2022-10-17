package rahulshettyacademy.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        //ExtentReports, ExtentSparkReporter
       String path =  System.getProperty("user.dir") +"\\reports\\index.html";


        // The modification of the extent report done by Extent Spark Reporter class
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("WebAutomationResults");
        reporter.config().setDocumentTitle("Test Results");

      //  ExtentReports extent = new ExtentReports();

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Md Kabir");

    }

    @Test
    public void initialDemo(){

        // used the ExtentReport object at the beginning of the test to monitor the current test
        ExtentTest test  = extent.createTest("Learning Extent Report");
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");
        System.out.println(driver.getTitle());
        //driver.quit();
        test.fail(" Result dont match");
        extent.flush();
        driver.quit();
    }

}
