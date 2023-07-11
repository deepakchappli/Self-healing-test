package com.applitools.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;


public class AcmeBankTests {

    // Test constants
    private final static boolean USE_ULTRAFAST_GRID = true;
    private final static boolean USE_EXECUTION_CLOUD = true;
    private final static String RUNNER_NAME = (USE_ULTRAFAST_GRID) ? "Ultrafast Grid" : "Classic runner";
    private final static BatchInfo BATCH = new BatchInfo("Example: Selenium Java Basic with the " + RUNNER_NAME);

    public static void main(String [] args) {

        EyesRunner runner = null;
        Eyes eyes = null;
        WebDriver driver = null;


        try {

            if (USE_ULTRAFAST_GRID) {

                runner = new VisualGridRunner(new RunnerOptions().testConcurrency(5));
            }
            else {
                // Create the Classic runner.
                runner = new ClassicRunner();
            }

            eyes = new Eyes(runner);



            Configuration config = eyes.getConfiguration();

            boolean headless = Boolean.parseBoolean(System.getenv().getOrDefault("HEADLESS", "false"));

            config.setApiKey("UTdCHMb4kq8M78fD7F815320LN8IOMnLikn0Bhw106TqQ110");

            config.setBatch(BATCH);

            if (USE_ULTRAFAST_GRID) {

                config.addBrowser(800, 600, BrowserType.CHROME);
                config.addBrowser(1600, 1200, BrowserType.FIREFOX);
                config.addBrowser(1024, 768, BrowserType.SAFARI);

                config.addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT);
                config.addDeviceEmulation(DeviceName.Nexus_10, ScreenOrientation.LANDSCAPE);
            }


            eyes.setConfiguration(config);

            ChromeOptions options = new ChromeOptions().setHeadless(headless);
//            options.setCapability("apiKey", "UTdCHMb4kq8M78fD7F815320LN8IOMnLikn0Bhw106TqQ110");
            options.setCapability("applitools:eyesServerUrl","https://eyesapi.applitools.com");
            options.setCapability("applitools:apiKey","UTdCHMb4kq8M78fD7F815320LN8IOMnLikn0Bhw106TqQ110");
            options.setCapability( "applitools:sessionName", "Demo");


            if (USE_EXECUTION_CLOUD) {

                driver = new RemoteWebDriver(new URL(Eyes.getExecutionCloudURL()), options);
            }
            else {
                driver = new ChromeDriver(options);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            eyes.open(

                driver,

                "ACME Bank Web App",

                "Log into bank account",
                

                new RectangleSize(1200, 600));

            // Load the login page.
            driver.get("https://demo.applitools.com");

            String script = "document.querySelector('#log-in').id = 'New_button';";
            ((JavascriptExecutor) driver).executeScript(script);

            // Verify the full login page loaded correctly.
            eyes.check(Target.window().fully().withName("Login page"));

            // Perform login.
            driver.findElement(By.id("username")).sendKeys("applibot");
            driver.findElement(By.id("password")).sendKeys("I<3VisualTests");
            driver.findElement(By.id("log-in")).click();

            // Verify the full main page loaded correctly.
            // This snapshot uses LAYOUT match level to avoid differences in closing time text.
            eyes.check(Target.window().fully().withName("Main page").layout());

            // Close Eyes to tell the server it should display the results.
            eyes.closeAsync();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (eyes != null)
                eyes.abortAsync();
        }

        try {
            if (driver != null)
                driver.quit();

            if (runner != null) {
                TestResultsSummary allTestResults = runner.getAllTestResults();
                System.out.println(allTestResults);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
