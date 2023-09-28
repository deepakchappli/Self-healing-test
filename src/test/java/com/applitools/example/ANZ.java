package com.applitools.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.*;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;


public class ANZ {

    // Test constants
    private final static boolean USE_ULTRAFAST_GRID = true;
    private final static boolean USE_EXECUTION_CLOUD = false;
    private final static String RUNNER_NAME = (USE_ULTRAFAST_GRID) ? "Ultrafast Grid_EC" : "Classic runner";
    private final static BatchInfo BATCH = new BatchInfo("ANZ_Self_Heal " + RUNNER_NAME);

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

            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_14, ScreenOrientation.PORTRAIT, IosVersion.LATEST));
            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_14_Pro_Max, ScreenOrientation.PORTRAIT, IosVersion.LATEST));
            config.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_13_Pro, ScreenOrientation.PORTRAIT, IosVersion.LATEST));

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
                    "ANZ_selenium",
                    "anz_EC",
                    new RectangleSize(1200, 600));

            // Load the home page.
            driver.get("https://www.anz.com.au/personal/credit-cards/low-interest-rate-card/");
            driver.manage().window().maximize();



//            //colour change
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            String scripts = "var element = document.querySelector('#content-anzcomau-en-personal-credit-cards-low-interest-rate-card-navigation-anz_hero_par-start > div.heroSplitBanner > div.anz-component.hero > div > div > div.hero__grid.hero__grid--splitBannerImage.clearfix > div > div.hero__columnContent.hero__columnContent--withImage > div > p.rte--body1-regular.padding-top--0px.margin-bottom--20px > a');"
//                    + "element.style.color = 'orange';";
//            executor.executeScript(scripts);

//            Execute JavaScript
//            JavascriptExecutor step = (JavascriptExecutor) driver;
//            String steps = "var element = document.querySelector('#main-container > div:nth-child(1) > div > div > div.clearfix > div > div > div:nth-child(2) > div.box--top > div > div > h3 > span');"
//                    + "element.textContent = '28.99% p.a.'";
//            step.executeScript(steps);

//             Execute JavaScript
//            JavascriptExecutor fonts = (JavascriptExecutor) driver;
//            String font = "var element = document.querySelector('#main-container > div:nth-child(11) > div > div > div.border.box--pale-blue.clearfix > div.container__items.container__aside.none.none > div > div > div > h3');"
//                    + "element.style.fontFamily = 'Aerial';";
//            fonts.executeScript(font);

            eyes.check(Target.window().fully().withName("ANZ Low Rate credit card"));

            //apply with a bank transfer
            WebElement transfer = driver.findElement(By.cssSelector("#main-container > div:nth-child(3) > div > div > div.clearfix > div.container__items.container__main.none.none > div > div > div.box--top > div > p:nth-child(9) > a"));
            transfer.click();

            //switch the tab
            WebDriver finalDriver = driver;
            driver.getWindowHandles().forEach(tab-> finalDriver.switchTo().window(tab));

            JavascriptExecutor jsExecutors = (JavascriptExecutor) driver;
            jsExecutors.executeScript("window.scrollTo(0, document.body.scrollHeight)");

           Thread.sleep(3000);
//          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
          WebElement no = driver.findElement(By.cssSelector("#customerType_No"));
//           WebElement no = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customerType_No\"]")));
//            System.out.println("Before changing:" + driver.findElement(By.id("customerType_No")).getAttribute("id"));

            //Self Heal
//            String change = "document.querySelector('#customerType_No').setAttribute('id','newSelector');";
//            ((JavascriptExecutor) driver).executeScript(change);
//            JavascriptExecutor icon = (JavascriptExecutor) driver;
//            String logo = "document.querySelector('#customerType_No').setAttribute('id', 'No')";
//            icon.executeScript(logo);
//            System.out.println("After changing:" + driver.findElement(By.id("customerType_No")).getAttribute("id"));
            no.click();

           WebElement next = driver.findElement(By.id("next-submit"));
           eyes.check(Target.window().fully().withName("Let's get started"));
           next.click();

//             Execute JavaScript
//            JavascriptExecutor aia = (JavascriptExecutor) driver;
//            String logo = "var element = document.querySelector('#root > div > div > header > div > div > div > div > img');"
//                    + "element.style.display = 'none';";
//            aia.executeScript(logo);

            Thread.sleep(2000);
//            // Execute JavaScript
//            JavascriptExecutor policy = (JavascriptExecutor) driver;
//            String policies = "var element = document.querySelector('#root > div > div > div.sc-kGXeez.eLXYjD.sc-iFMziU.hhpcGQ > div > div.sc-dxgOiQ.hCLtlI.sc-cBdUnI.cngnxo > div > nav > div > div:nth-child(7) > section > header > button > span.NavigationPageListItem-section > svg');"
//                    + "element.style.display = 'none';";
//            policy.executeScript(policies);

//            Execute JavaScript to hide the element twitter
//            JavascriptExecutor drps = (JavascriptExecutor) driver;
//            String drpdwns = "var element = document.querySelector('#root > div > div > div.sc-kGXeez.eLXYjD.sc-iFMziU.hhpcGQ > div > div.sc-dxgOiQ.gprrqV.sc-gVLVqr.cnRbET > div > form > div:nth-child(2) > button:nth-child(3)');"
//                    + "element.style.display = 'none';";
//            drps.executeScript(drpdwns);

            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);
//            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(next));
//            new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("next-submit")));
            WebElement next1 = driver.findElement(By.id("next-submit"));
            next1.click();
            Thread.sleep(2000);

            // Execute JavaScript
//            JavascriptExecutor Disc = (JavascriptExecutor) driver;
//            String disclaimer = "var element = document.querySelector('#root > div > div > div.sc-kGXeez.eLXYjD.sc-iFMziU.hhpcGQ > div > div.sc-dxgOiQ.gprrqV.sc-gVLVqr.cnRbET > div > form > section > ul > li:nth-child(3) > a');"
//                    + "element.textContent = 'Please enter your Middle name';";
//            Disc.executeScript(disclaimer);
            eyes.check(Target.window().fully().withName("Personal Details Error"));

            Select objSelect =new Select(driver.findElement(By.id("personal.title")));
            objSelect.selectByVisibleText("Mr");
            WebElement male = driver.findElement(By.id("personal.gender_Male"));
            male.click();
            WebElement firstName = driver.findElement(By.id("personal.firstName"));

            //Self Heal
            // Execute JavaScript
            String nameChange = "document.getElementById('personal.firstName').setAttribute('id','firstname');";
            ((JavascriptExecutor) driver).executeScript(nameChange);

            firstName.sendKeys("Deepak");
            driver.findElement(By.id("personal.isHavingMiddleName_No")).click();
            driver.findElement(By.id("personal.lastName")).sendKeys("Choudhary");
            driver.findElement(By.id("personal.dateOfBirthDay")).sendKeys("01");
            driver.findElement(By.id("personal.dateOfBirthMonth")).sendKeys("01");
            driver.findElement(By.id("personal.dateOfBirthYear")).sendKeys("1997");
            driver.findElement(By.id("personal.email")).sendKeys("test@applitools.com");
            driver.findElement(By.id("contactNumbers.mobileNumber")).sendKeys("0411511111");
            eyes.check(Target.window().fully().withName("Personal Details"));
            next1.click();

            Thread.sleep(3000);
            WebElement next2 = driver.findElement(By.id("next-submit"));
            next2.click();
            eyes.check(Target.window().fully().withName("Address error"));
            driver.findElement(By.id("residency.status_No")).click();
            WebElement address = driver.findElement(By.id("address.residentialAddress.fullAddress"));
            address.sendKeys("Shop 1  257 Collins Street, MELBOURNE  VIC  300");
            Thread.sleep(3000);
//            new WebDriverWait(driver, Duration.ofSeconds(7));
            address.sendKeys(Keys.ARROW_DOWN);
            address.sendKeys(Keys.ENTER);
            driver.findElement(By.id("address.residentialAddress.fullAddress_sub_label")).click();
            Select years =new Select(driver.findElement(By.id("address.residentialAddress.years")));
            years.selectByVisibleText("7");
            Select months =new Select(driver.findElement(By.id("address.residentialAddress.months")));
            months.selectByVisibleText("9");
            driver.findElement(By.id("livingConditions.livingSituation_Other")).click();

//            Execute JavaScript
//            JavascriptExecutor renting = (JavascriptExecutor) driver;
//            String rent = "var element = document.querySelector('#root > div > div > div.sc-kGXeez.eLXYjD.sc-kfGgVZ.dExkIr > div > div:nth-child(1) > ul > li:nth-child(3) > a');"
//                    + "element.style.display = 'none';";
//            renting.executeScript(rent);

            eyes.check(Target.window().fully().withName("Address"));
            next2.click();

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

//            eyes.check(Target.region(By.cssSelector("body > div")).withName("Region screenshot"));
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
