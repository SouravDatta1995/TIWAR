package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// page_url = http://tiwar.net/cave/
public class TiwarCavePage extends TiwarBasePage {

    private static TiwarCavePage instance;

    private TiwarCavePage() {
    }

    public static synchronized TiwarCavePage getInstance() {
        if (instance == null) {
            instance = new TiwarCavePage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarCavePage.class);
    private final SelenideElement newSearch = $(byText("New search"));
    private final SelenideElement startMining = $(byText("Start mining"));
    private final SelenideElement attack = $x("//a[contains(@href, 'attack')]");
    TiwarAttributes tiwarAttributes = TiwarAttributes.getInstance();
    
    @Override
    public String url() {
        return "/cave";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Cave");
        open(url());
        if (newSearch.exists()) {
            newSearch.click();
            TASK_STATE.setLastExecuted(LocalDateTime.now());
        }
        if (startMining.exists()) {
            startMining.click();
            TASK_STATE.setLastExecuted(LocalDateTime.now());
        }
        if (attack.exists() && tiwarAttributes.getHealth() > 1500) {
            attack.click();
            TASK_STATE.setLastExecuted(LocalDateTime.now());
        }
    }
}