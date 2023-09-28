package com.applitools.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.*;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;


public class VeroInsurance_SelfHeal {

    // Test constants
    private final static boolean USE_ULTRAFAST_GRID = true;
    private final static boolean USE_EXECUTION_CLOUD = true;

    private final static boolean introduce_Eyes_Changes = true;

    private final static boolean introduce_SelfHeal_Changes = true;
    private final static String RUNNER_NAME = (USE_ULTRAFAST_GRID) ? "Ultrafast Grid_EC" : "Classic runner";
    private final static BatchInfo BATCH = new BatchInfo("Vero Claims SelfHeal " + RUNNER_NAME);

    public static void main(String [] args) {

        VisualGridRunner runner = null;
        Eyes eyes = null;
        WebDriver driver = null;

        try {

            runner = new VisualGridRunner(new RunnerOptions().testConcurrency(50));

            eyes = new Eyes(runner);

            Configuration config = eyes.getConfiguration();

            config.setApiKey("UTdCHMb4kq8M78fD7F815320LN8IOMnLikn0Bhw106TqQ110");

            boolean headless = Boolean.parseBoolean(System.getenv().getOrDefault("HEADLESS", "false"));

            config.setBatch(BATCH);

            config.addBrowser(800, 600, BrowserType.CHROME);
            config.addBrowser(1600, 1200, BrowserType.FIREFOX);
            config.addBrowser(1024, 768, BrowserType.SAFARI);
            config.addBrowser(1024, 800, BrowserType.CHROME_ONE_VERSION_BACK);
            config.addBrowser(1920, 1080, BrowserType.FIREFOX_ONE_VERSION_BACK);
            config.addBrowser(1200, 600, BrowserType.FIREFOX_TWO_VERSIONS_BACK);
            config.addBrowser(1024, 768, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(800, 768, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1024, 800, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(800, 600, BrowserType.SAFARI);
            config.addBrowser(1920, 1080, BrowserType.SAFARI_TWO_VERSIONS_BACK);
            config.addBrowser(1024, 1200, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(800, 1080, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1000, 800, BrowserType.CHROME);
            config.addBrowser(1200, 600, BrowserType.FIREFOX);
            config.addBrowser(800, 600, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1200, 600, BrowserType.FIREFOX_ONE_VERSION_BACK);
            config.addBrowser(1024, 600, BrowserType.CHROME_ONE_VERSION_BACK);
            config.addBrowser(1024, 600, BrowserType.CHROME_TWO_VERSIONS_BACK);
            config.addBrowser(1024, 600, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1024, 800, BrowserType.CHROME);
            config.addBrowser(1024, 800, BrowserType.SAFARI);
            config.addBrowser(1920, 800, BrowserType.FIREFOX);
            config.addBrowser(1024, 700, BrowserType.CHROME_ONE_VERSION_BACK);
            config.addBrowser(1024, 500, BrowserType.CHROME_ONE_VERSION_BACK);
            config.addBrowser(800, 1080, BrowserType.CHROME);
            config.addBrowser(1024, 600, BrowserType.SAFARI);
            config.addBrowser(800, 768, BrowserType.CHROME_ONE_VERSION_BACK);
            config.addBrowser(1024, 800, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(900, 500, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1024, 1080, BrowserType.CHROME);
            config.addBrowser(1024, 600, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(1024, 768, BrowserType.SAFARI);
            config.addBrowser(1024, 768, BrowserType.FIREFOX_ONE_VERSION_BACK);

            // Other mobile devices are available, including iOS.
            config.addDeviceEmulation(DeviceName.Pixel_4_XL, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.Galaxy_S20, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.iPhone_11_Pro_Max, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.iPhone_11_Pro, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.iPad_Air_2, ScreenOrientation.PORTRAIT);

            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_14, ScreenOrientation.PORTRAIT, IosVersion.LATEST));
            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_13, ScreenOrientation.PORTRAIT, IosVersion.LATEST));
            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_14_Pro_Max, ScreenOrientation.PORTRAIT, IosVersion.LATEST));

            eyes.setConfiguration(config);
            eyes.setIgnoreDisplacements(true);

            ChromeOptions options = new ChromeOptions().setHeadless(headless);
//            driver = new ChromeDriver(options);
            options.setCapability("applitools:eyesServerUrl","https://eyesapi.applitools.com");
            options.setCapability("applitools:apiKey","UTdCHMb4kq8M78fD7F815320LN8IOMnLikn0Bhw106TqQ110");
            options.setCapability("applitools:region", "australia");

            if (USE_EXECUTION_CLOUD) {

                driver = new RemoteWebDriver(new URL(Eyes.getExecutionCloudURL()), options);
            }
            else {
                driver = new ChromeDriver(options);
            }

            eyes.open(
                    driver,
                    "Vero SH_NZ_1",
                    "Vero Claim_1",
                    new RectangleSize(1200, 600));

            // Load the home page.
            driver.get("https://claims.vero.co.nz/ClaimForm/claim/selectClaimType.html");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            eyes.check(Target.window().fully().withName("Home Page"));
            WebElement waitforPageload = driver.findElement(By.xpath("//*[@id=\"selectClaimTypeHeader\"]"));
            System.out.println(waitforPageload.getText());
            WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"bottomNavigationBarNextButton\"]"));
            nextButton.click();

            eyes.check(Target.window().fully().withName("Claim Selection Error"));
            WebElement carGlass = driver.findElement(By.xpath("//*[@id='WINDSCREEN']"));
            carGlass.click();

            eyes.check(Target.window().fully().withName("Claim Selection"));

            new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("bottomNavigationBarNextButton")));
            driver.findElement(By.id("bottomNavigationBarNextButton")).click();

            // nextButton.click();
            eyes.check(Target.window().fully().withName("Your details"));

            new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("bottomNavigationBarNextButton")));
            driver.findElement(By.id("bottomNavigationBarNextButton")).click();

            eyes.check(Target.window().fully().withName("Details Error screen"));


            driver.findElement(By.id("customerNumber")).sendKeys("12345678");
            driver.findElement(By.id("fullNameOfInsured")).sendKeys("Satish Mallela");

            if(introduce_SelfHeal_Changes){
                System.out.println("Before changing:" + driver.findElement(By.id("sameAsAboveCheckbox")).getAttribute("id"));
                JavascriptExecutor icon = (JavascriptExecutor) driver;
                String logo = "document.querySelector('#sameAsAboveCheckbox').setAttribute('id', 'sameCheckbox')";
                icon.executeScript(logo);
                System.out.println("After changing:" + driver.findElement(By.id("sameAsAboveCheckbox")).getAttribute("id"));
            }

            driver.findElement(By.id("sameAsAboveCheckbox")).click();

            driver.findElement(By.id("fullName")).sendKeys("Satish Mallela");

            driver.findElement(By.id("contactDetailsemail")).sendKeys("satish1@applitools.com");

            driver.findElement(By.id("postalAddressStreetNameOrPOBox")).sendKeys("PO 1234");

            driver.findElement(By.id("postalAddressSuburbOrTown")).sendKeys("Auckland");

            driver.findElement(By.id("postalAddressCityOrRegion")).sendKeys("Auckland");

            driver.findElement(By.id("postalAddressPostcode")).sendKeys("3000");

            driver.findElement(By.id("situationInsuredDifferentFromPostalAddressFalse")).click();

            Select objSelect =new Select(driver.findElement(By.id("preferredMethodOfContact")));
            objSelect.selectByVisibleText("Email");

            driver.findElement(By.id("areYouTheInsuredTrue")).click();

            driver.findElement(By.id("preferredMethodOfPayment2")).click();

            driver.findElement(By.id("knowsBrokerDetailsFalse")).click();

            eyes.check(Target.window().fully().withName("After Your details"));

            new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("bottomNavigationBarNextButton")));
            driver.findElement(By.id("bottomNavigationBarNextButton")).click();

            //added code:
            //Thread.sleep(3000);
            WebElement yes = driver.findElement(By.id("agreedTrue"));
            yes.click();

            eyes.check(Target.window().fully().withName("Privacy Declaration"));

            driver.findElement(By.id("bottomNavBarNextButton")).click();

            new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("bottomNavigationBarNextButton")));
            driver.findElement(By.id("bottomNavigationBarNextButton")).click();

            eyes.check(Target.window().fully().withName("Error Claim Details"));

            //code to make the differences
            Select location =new Select(driver.findElement(By.id("whereOptionSelect")));
            location.selectByVisibleText("Other");

            driver.findElement(By.id("doNotKnowDateTimeOfDamageOrLossFalse")).click();

            if(introduce_Eyes_Changes){
                JavascriptExecutor removeDiv = (JavascriptExecutor) driver;
                String div_footer = "document.querySelector('#PageFooter').remove()";
                removeDiv.executeScript(div_footer);
            }

            eyes.check(Target.window().fully().withName("Claim Details"));
            eyes.closeAsync();
        }
        catch (Exception e) {
            // Dump any errors and abort any tests.
            e.printStackTrace();
            if (eyes != null)
                eyes.abortAsync();
        }

        try {
            // No matter what, perform cleanup.
            if (driver != null)
                driver.quit();

            if (runner != null) {
                TestResultsSummary allTestResults = runner.getAllTestResults();
                System.out.println(allTestResults);
            }
        }
        catch (Exception e) {
            // Dump any cleanup errors.
            e.printStackTrace();
        }

        // Always force execution to end.
        System.exit(0);
    }
}