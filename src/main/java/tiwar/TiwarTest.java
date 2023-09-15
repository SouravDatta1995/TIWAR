package tiwar;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    public static void main(String[] args) {
        Configuration.browser = Browsers.EDGE;
        Configuration.browserCapabilities = new EdgeOptions();
        Configuration.baseUrl = "http://tiwar.net";
        Timer timer = new Timer();
        timer.schedule(new TiwarTasks(), 0, TimeUnit.MINUTES.toMillis(3));
    }
}
