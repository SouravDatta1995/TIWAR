package tiwar;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    public static void main(String[] args) {
        Configuration.browser = Browsers.FIREFOX;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless=new");
        Configuration.browserCapabilities = firefoxOptions;
        Configuration.baseUrl = "http://tiwar.net";
        Timer timer = new Timer();
        timer.schedule(new TiwarTasks(), 0, TimeUnit.MINUTES.toMillis(3));
    }
}
