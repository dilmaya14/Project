package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.internal.ReporterConfig.Property;

public class Baseclass {
    
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {
    	
    	FileReader file= new FileReader("C:\\Users\\dilmaya\\eclipse-workspace\\Project\\src\\test\\resources\\config.properties");
    	p= new Properties();
    	p.load(file);
    	
        logger = LogManager.getLogger(this.getClass());

        logger.info("OS: " + os);
        logger.info("Browser: " + br);

        switch(br.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Invalid browser name");
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(p.getProperty("url"));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}