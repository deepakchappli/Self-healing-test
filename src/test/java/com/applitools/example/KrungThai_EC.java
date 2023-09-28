package com.applitools.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;


public class KrungThai_EC {

    // Test constants
    private final static boolean USE_ULTRAFAST_GRID = true;
    private final static boolean USE_EXECUTION_CLOUD = true;
    private final static String RUNNER_NAME = (USE_ULTRAFAST_GRID) ? "Ultrafast Grid_EC" : "Classic runner";
    private final static BatchInfo BATCH = new BatchInfo("Krung Bank Demo Thai<>ENG " + RUNNER_NAME);

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
            config.addDeviceEmulation(DeviceName.iPhone_11, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.Galaxy_Note_10_Plus, ScreenOrientation.PORTRAIT);



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
                    "Krung_selenium",
                    "Krung_self_healing",
                    new RectangleSize(1200, 600));

            // Load the home page.
            driver.get("https://krungthai.com/en/content/personal/cards/credits");


//            overlapping text for the changes.
//            JavascriptExecutor jExecutor = (JavascriptExecutor) driver;
//            String script = "var element = document.createElement('div');"
//                    + "element.style.position = 'absolute';"
//                    + "element.style.top = '50%';"
//                    + "element.style.left = '50%';"
//                    + "element.style.transform = 'translate(-50%, -50%)';"
//                    + "element.style.zIndex = '9999';"
//                    + "element.style.backgroundColor = 'rgba(255, 255, 255, 0.8)';"
//                    + "element.style.padding = '20px';"
//                    + "element.style.fontSize = '20px';"
//                    + "element.textContent = 'CLICK';"
//                    + "document.body.appendChild(element);";
//            jExecutor.executeScript(script);
//
//            //colour change of the Krungthai NEXT button at the top
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            String scripts = "var element = document.querySelector('#content > div.block4 > div.blocktitle > div > div > div > div > div > a');"
//                    + "element.style.color = 'orange';";
//            executor.executeScript(scripts);
//
//            //change color of the KTC Forever section
//            JavascriptExecutor taxes = (JavascriptExecutor) driver;
//            String tax = "var element = document.querySelector('#content > div.block2 > div.block2-inner1 > div > div > div.row > div:nth-child(3) > div.ktfast-regular.blue');"
//                    + "element.style.color = 'green';";
//            taxes.executeScript(tax);
//
////            Execute JavaScript to change the text isclaimer
//            JavascriptExecutor step = (JavascriptExecutor) driver;
//            String steps = "var element = document.querySelector('#content > div.block1 > div.blocktitle > div > div > div > div > div > div.ktfast-normal.mainsubtitle.aos-init.aos-animate');"
//                    + "element.textContent = 'สัมผัสบัตรเรดิตที่ตอบควมเป็นตัวคุณ'";
//            step.executeScript(steps);
//
//            // Execute JavaScript to change the font style of "Bottom section"
//            JavascriptExecutor fonts = (JavascriptExecutor) driver;
//            String font = "var element = document.querySelector('#divFindFooterEN > div > div > div > div > div.border-r.divfoot1 > div.itemtxt > div > a > span:nth-child(2)');"
//                    + "element.style.fontFamily = 'Aerial';";
//            fonts.executeScript(font);
//
//            // Scroll to the bottom of the page
            JavascriptExecutor jsExecutors = (JavascriptExecutor) driver;
            jsExecutors.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            eyes.check(Target.window().fully().withName("Apply for credit card Page").layout());

            WebElement apply= driver.findElement(By.xpath("//span[@class='forcebreakline']"));

            //change the selector
//            String newCssSelector = "#new-selector";
//            String change = "arguments[0].style.contentText = '" + newCssSelector + "';";
//            ((JavascriptExecutor) driver).executeScript(change, apply);


            String change = "document.querySelector('.forcebreakline').setAttribute('class','forcebreakline2');";
            ((JavascriptExecutor) driver).executeScript(change);

            WebElement pathx = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/div/div/div/div/a/span"));
            System.out.println("value of the attribute" + pathx.getAttribute("class"));
            apply.click();

            WebDriver finalDriver = driver;
            driver.getWindowHandles().forEach(tab-> finalDriver.switchTo().window(tab));

            WebElement cookies = driver.findElement(By.cssSelector("#Credit\\ Card\\ 2023\\ -\\ Add\\ Articles > div.cookie-wrapper__c > div > div > div.dialog-1__c > div.flex-between__c.flex-reverse-mobile > input.button__c"));
            cookies.click();

//             Execute JavaScript to hide the KTC logo
//            JavascriptExecutor aia = (JavascriptExecutor) driver;
//            String logo = "var element = document.querySelector('#ktc-logo > a > img');"
//                    + "element.style.display = 'none';";
//            aia.executeScript(logo);
//
//            // Execute JavaScript to hide the credit card section
//            JavascriptExecutor policy = (JavascriptExecutor) driver;
//            String policies = "var element = document.querySelector('#product > div.row.mt-4 > div:nth-child(11) > div > div.credit-card-content.text-center > a:nth-child(2)');"
//                    + "element.style.display = 'none';";
//            policy.executeScript(policies);
//
//            // Execute JavaScript to change the text KTC VISA SIGNATURE
//            JavascriptExecutor Disc = (JavascriptExecutor) driver;
//            String disclaimer = "var element = document.querySelector('#product > div.row.mt-4 > div:nth-child(2) > div > div.credit-card-content.text-center > h2');"
//                    + "element.textContent = 'KTC ASIV SIGNATURE';";
//            Disc.executeScript(disclaimer);
//
//            // Execute JavaScript to hide the element needs to change (Browser statement)
//            JavascriptExecutor drp = (JavascriptExecutor) driver;
//            String drpdwn = "var element = document.querySelector('#apply-details > div > div:nth-child(2) > div:nth-child(1) > div > div > div.card-title.qualification');"
//                    + "element.style.display = 'none';";
//            drp.executeScript(drpdwn);
//
////             Execute JavaScript to hide the element twitter
//            JavascriptExecutor drps = (JavascriptExecutor) driver;
//            String drpdwns = "var element = document.querySelector('#ft-hide > div.content-wrap.last-piece > div > div.col-lg-6.text-right > div.social-footer > a:nth-child(2) > img.on-default');"
//                    + "element.style.display = 'none';";
//            drps.executeScript(drpdwns);

            eyes.check(Target.window().fully().waitBeforeCapture(2000).withName("Credit cards Page"));

            driver.findElement(By.cssSelector("#product > div.row.mt-4 > div:nth-child(1) > div > div.credit-card-content.text-center > a.btn-pill-red")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Integer size = driver.findElements(By.tagName("iframe")).size();

            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//input[@name='fname']")).click();
            driver.findElement(By.name("fname")).sendKeys("applitools");
            driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("test1");
            driver.findElement(By.xpath("//input[@name='tel']")).sendKeys("0299999999");
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("applit0ols@test.com");

            Select salary = new Select(driver.findElement(By.xpath("//*[@id='salary']")));
            salary.selectByValue("9");


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

            eyes.check(Target.region(By.cssSelector("body > div")).withName("Region screenshot"));
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
