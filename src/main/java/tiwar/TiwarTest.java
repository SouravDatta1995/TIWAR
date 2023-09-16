package tiwar;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarTest.class);

    public static void main(String[] args) {
        if (args.length <= 2) {
            System.out.println("Please provide the Browser,Headless and WebDriver path as an argument." +
                    "If not Selenide will Automatically select");
        } else {
            String webDriverPath = args[2];
            System.setProperty("webdriver.gecko.driver", webDriverPath);
        }
        Configuration.baseUrl = "http://tiwar.net";
        LOGGER.info("Tiwar Automate STarted with " + args[0] + " Headless " + args[1]);
        Timer timer = new Timer();
        timer.schedule(new TiwarTasks(args[0], args[1]), 0, TimeUnit.MINUTES.toMillis(3));
    }
}
