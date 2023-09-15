package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

// page_url = http://tiwar.net/career/
public class TiwarCareerPage extends TiwarBasePage {

    private static TiwarCareerPage instance;

    private TiwarCareerPage() {
    }

    public static synchronized TiwarCareerPage getInstance() {
        if (instance == null) {
            instance = new TiwarCareerPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarCareerPage.class);
    private final SelenideElement linkAttack = $x("//a[contains(@href, '/career/attack')]");
    public SelenideElement linkTakeReward = $x("//a[contains(@href, '/career/take')]");

    @Override
    public String url() {
        return "/career";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Career");
        open(url());
        while (linkAttack.exists()) {
            linkAttack.click();
        }
        if (linkTakeReward.exists()) {
            LOGGER.info("Collect Career Reward");
            linkTakeReward.click();
        }
    }
}