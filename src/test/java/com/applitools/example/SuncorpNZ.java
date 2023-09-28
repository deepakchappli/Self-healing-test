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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;


public class SuncorpNZ {

    // Test constants
    private final static boolean USE_ULTRAFAST_GRID = true;
    private final static boolean USE_EXECUTION_CLOUD = false;
    private final static String RUNNER_NAME = (USE_ULTRAFAST_GRID) ? "Ultrafast Grid_EC" : "Classic runner";
    private final static BatchInfo BATCH = new BatchInfo("Suncorp NZ Insurance " + RUNNER_NAME);

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

            eyes.setForceFullPageScreenshot(true);
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
                    "Suncorp",
                    "Suncorp",
                    new RectangleSize(1200, 600));

            // Load the home page.
//            driver.get("https://www.suncorp.co.nz/");
//
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////            JavascriptExecutor icon = (JavascriptExecutor) driver;
////            String logo = "var element = document.evaluate('//*[starts-with(@id,'img_all_views')]');"
////                    + "element.style.display = 'none';";
////            icon.executeScript(logo);
//
////            // Execute JavaScript to hide the aa insurance logo
////            JavascriptExecutor policy = (JavascriptExecutor) driver;
////            String policies = "var element = document.querySelector('#ContentBoxContainer_91a61ab0fc364c559b1811812c9104b3 > div > img');"
////                    + "element.style.display = 'none';";
////            policy.executeScript(policies);
//
//            // Execute JavaScript to change the text Our brands at the bottom
////            JavascriptExecutor Disc = (JavascriptExecutor) driver;
////            String disclaimer = "var element = document.querySelector('body > div.Page > div:nth-child(5) > div > div > div.iparys_inherited > div:nth-child(2) > div > div:nth-child(1) > a:nth-child(3)');"
////                    + "element.textContent = 'Our Brand$';";
////            Disc.executeScript(disclaimer);
//
//            eyes.check(Target.window().fully().withName("Home Page"));
//
//            JavascriptExecutor jsExecutors = (JavascriptExecutor) driver;
//            jsExecutors.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//            WebElement careers= driver.findElement(By.xpath("(//a[@class=\"sg-Btn sg-Btn--secondary\"])[2]\n"));
//
////            Self-Heal
////            String newXPath = "//a[contains(@class, 'sg-Btn') and contains(@class, 'sg-Btn--secondary')][2]"; // Replace with your desired new XPath
////
////            // Use JavaScript to locate the element with the new XPath
////            // Use JavascriptExecutor to change the element's XPath attribute
////            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
////            jsExecutor.executeScript(
////                    "arguments[0].setAttribute('xpath', arguments[1]);",
////                    careers,
////                    newXPath
////            );
//
//
//            careers.click();
//
////
////            // Execute JavaScript to hide the element linked icon
////            JavascriptExecutor drp = (JavascriptExecutor) driver;
////            String drpdwn = "var element = document.querySelector('#ContentBoxContainer_68b0078a10ae4a42bc89762c49691541 > div:nth-child(4) > p > i');"
////                    + "element.style.display = 'none';";
////            drp.executeScript(drpdwn);
//
////             Execute JavaScript to hide the element twitter
////            JavascriptExecutor drps = (JavascriptExecutor) driver;
////            String drpdwns = "var element = document.querySelector('body > div.Page > main > div > div:nth-child(7) > section > div.Middle-column.Middle-column--Thinner---Top.Middle-column--Thin---Bottom > div > div > div.sg-Grid-col12.sg-Grid-col5--large.sg-Grid-col5--xlarge.grid-column > div > div > img');"
////                    + "element.style.display = 'none';";
////            drps.executeScript(drpdwns);
//
//            //colour change
////            JavascriptExecutor executor = (JavascriptExecutor) driver;
////            String scripts = "var element = document.querySelector('#ContentBoxContainer_d46f8868fe774cccb373ee97c1329a3f > div:nth-child(1) > p > span');"
////                    + "element.style.color = 'orange';";
////            executor.executeScript(scripts);
//
//            eyes.check(Target.window().fully().withName("Careers"));
//
//            //click on the apply button
//            WebElement applied = driver.findElement(By.xpath("//a[contains(@class, 'sg-Btn--primary')]\n"));
//           //Self Heal
////            String newCssSelector = "#new-selector";
////            String change = "arguments[0].style.contentText = '" + newCssSelector + "';";
////            ((JavascriptExecutor) driver).executeScript(change, applied);
//            applied.click();
//
//            //Execute JavaScript to hide the element Banking consultant
////            JavascriptExecutor bank = (JavascriptExecutor) driver;
////            String banks = "var element = document.querySelector('#search-results-content > div:nth-child(5) > div > div.card-body');"
////                    + "element.style.display = 'none';";
////            bank.executeScript(banks);
//
//            //Execute JavaScript to hide the element Accessibility
////            JavascriptExecutor access = (JavascriptExecutor) driver;
////            String accessed = "var element = document.querySelector('body > footer > div > div:nth-child(2) > nav > ul > li:nth-child(2) > a');"
////                    + "element.style.display = 'none';";
////            access.executeScript(accessed);
//
//            // Execute JavaScript to change the text Our brands at the bottom
////            JavascriptExecutor color = (JavascriptExecutor) driver;
////            String colour = "var element = document.querySelector('body > section > div > div > div > p.m-0 > a:nth-child(2)');"
////                    + "element.textContent = 'Agency Signin';";
////            color.executeScript(colour);
//
//            eyes.check(Target.window().fully().layout().withName("Careers at Suncorp"));
//
//            //Search for sales engineer post
//            WebElement insert = driver.findElement(By.id("search-keyword"));
//            insert.sendKeys("Sales Engineer");
//
//            JavascriptExecutor jsExecutr = (JavascriptExecutor) driver;
//            jsExecutr.executeScript("window.scrollTo(0, 200)");
//
//            //select the first job
//            driver.findElement(By.cssSelector("#search-results-content > div:nth-child(1) > div > div.card-body > h4 > a")).click();
//
//            //Execute JavaScript to hide the element Banking consultant
////            JavascriptExecutor role = (JavascriptExecutor) driver;
////            String newRole = "var element = document.querySelector('#job-content > div > div:nth-child(3) > div.col-12.col-md-8 > div > p:nth-child(6) > strong');"
////                    + "element.style.display = 'none';";
////            role.executeScript(newRole);
//
//            //Execute JavaScript to hide the element Accessibility
////            JavascriptExecutor location = (JavascriptExecutor) driver;
////            String allLocation = "var element = document.querySelector('#location');"
////                    + "element.style.display = 'none';";
////            location.executeScript(allLocation);
//
//            // Execute JavaScript to change the text Our brands at the bottom
////            JavascriptExecutor nz = (JavascriptExecutor) driver;
////            String nza = "var element = document.querySelector('#job-content > div > div.row.align-items-center > div.col-12.col-md > p:nth-child(7)');"
////                    + "element.textContent = 'NZ-A8';";
////            nz.executeScript(nza);
//
//            eyes.check(Target.window().fully().withName("Sales and Underwriting Consultants"));
//
//            //click on the refer to a friend button
//            WebElement refer = driver.findElement(By.cssSelector("#job-content > div > div.row.align-items-center > div.col-auto > span:nth-child(1) > a"));
//            refer.click();
//
//            WebDriver finalDriver = driver;
//            driver.getWindowHandles().forEach(tab-> finalDriver.switchTo().window(tab));
//
//            //send email button
//            driver.findElement(By.id("sendEmailButton")).click();
//
//            // Execute JavaScript to change the text Our brands at the bottom
////            JavascriptExecutor email = (JavascriptExecutor) driver;
////            String fromEmail = "var element = document.querySelector('#frm_emailJob > fieldset > div:nth-child(5) > label');"
////                    + "element.textContent = 'From e-mail:';";
////            email.executeScript(fromEmail);
//
//            eyes.check(Target.window().fully().withName("Refer a friend Error"));
//
//            driver.findElement(By.id("sFromName")).sendKeys("applitools");
//            driver.findElement(By.id("sFromEmail")).sendKeys("applitools@test.com");
//            driver.findElement(By.id("sReferredFName")).sendKeys("APAC");
//            driver.findElement(By.id("sReferredLName")).sendKeys("test");
//            driver.findElement(By.id("sToEmail")).sendKeys("test@applitools.com");
//
//            driver.findElement(By.id("sendEmailButton")).click();
//
//            // Execute JavaScript to change the text Our brands at the bottom
////            JavascriptExecutor alert = (JavascriptExecutor) driver;
////            String alerts = "var element = document.querySelector('#mainInner > div.info');"
////                    + "element.textContent = 'Mismatch not detected, please try again to prove that you are not a robot';";
////            alert.executeScript(alerts);
//
//            eyes.check(Target.window().fully().withName("Refer a friend"));

//             Execute JavaScript to change the text isclaimer
//            JavascriptExecutor text = (JavascriptExecutor) driver;
//            String texts = "var element = document.querySelector('body > div > form > div.input-notice.col-12 > div > p');"
//                    + "element.textContent = 'ข้าพเจ้ารับทราบว่า ข้าพเจ้าแจ้งความประสงค์ขอสมัคช้ผลิตภัณฑ์กับบริษัทบัตรกรุงไทย จำกัด (มหาชน) () ผ่านช่องทางอิเล็กทรอนิกส์และข้าพเจ้ายินยอมให้เคทีซีใช้หรือเปิดเผยข้อมูลข้างต้นในการติดต่อข้าพเจ้า\u200Bและเพื่อประโยชน์ในการ\u200Bพิจารณาตามคำขอสมัครใช้ผลิตภัณฑ์\u200Bเคทีซีของข้าพเจ้า'";
//            text.executeScript(texts);
//
//            // Execute JavaScript to hide the element needs to change (Browser statement)
//            JavascriptExecutor step3 = (JavascriptExecutor) driver;
//            String steps3 = "var element = document.querySelector('body > div > h2');"
//                    + "element.style.display = 'none';";
//            step3.executeScript(steps3);
//        ------------------------xxx--------------------xxx----------------------------xxx-------------------

            driver.get("https://claims.vero.co.nz/ClaimForm/claim/selectClaimType.html");

            WebElement next = driver.findElement(By.id("topNavigationBarNextButton"));
            next.click();
            eyes.check(Target.window().fully().withName("Error"));

            driver.findElement(By.id("ACCIDENT")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            next.click();
            eyes.check(Target.window().fully().withName("without error"));

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
