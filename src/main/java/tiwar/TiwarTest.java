package tiwar;

import com.codeborne.selenide.Configuration;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TiwarTest {
    public static void main(String[] args) {
        Configuration.baseUrl = "http://tiwar.net";
        Configuration.headless = true;
        Timer timer = new Timer();
        timer.schedule(new TiwarTasks(), 0, TimeUnit.MINUTES.toMillis(3));
    }
}
