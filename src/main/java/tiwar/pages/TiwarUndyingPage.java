package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

// page_url = http://tiwar.net/undying/
public class TiwarUndyingPage {

    private static TiwarUndyingPage instance;

    private TiwarUndyingPage() {
    }

    public static synchronized TiwarUndyingPage getInstance() {
        if (instance == null) {
            instance = new TiwarUndyingPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarUndyingPage.class);
    public SelenideElement linkAttack = $x("//a[contains(@href, '/undying/hit')]");

    public SelenideElement spanTime = $x("//span[@id='time_5000']");

}