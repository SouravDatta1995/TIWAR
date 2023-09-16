package tiwar;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarTest.class);

    public static void main(String[] args) {
        Configuration.baseUrl = "http://tiwar.net";
        LOGGER.info("Tiwar Automate STarted with "+Configuration.browser+" Headless "+Configuration.headless);
        Timer timer = new Timer();
        timer.schedule(new TiwarTasks(), 0, TimeUnit.MINUTES.toMillis(3));
    }
}
