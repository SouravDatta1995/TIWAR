package tiwar;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarTest.class);

    public static void main(String[] args) throws InterruptedException {
        if (args.length <= 2) {
            System.out.println("Please provide the Browser,Headless and WebDriver path as an argument." +
                    "If not Selenide will Automatically select");
        }
        if(args.length>2) {
            System.setProperty("webdriver.gecko.driver", args[2]);
            WebDriver driver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        Configuration.browser = args[0];
        Configuration.headless = Boolean.parseBoolean(args[1]);
        Configuration.baseUrl = "http://tiwar.net";
        TiwarTasks tiwarTasks = new TiwarTasks(args);
        LOGGER.info("Tiwar Automate Started with " + args[0] + " Headless " + args[1]);
        while (true) {
            tiwarTasks.run();
            Thread.sleep(TimeUnit.SECONDS.toMillis(30));
        }
    }
}
