package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// page_url = http://tiwar.net/arena
public class TiwarArenaPage extends TiwarBasePage {

    private static TiwarArenaPage instance;
    private TiwarArenaPage() {
    }
    public static synchronized TiwarArenaPage getInstance() {
        if(instance == null) {
            instance = new TiwarArenaPage();
        }
        return instance;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarArenaPage.class);
    private static final SelenideElement attackBtn = $(byText("Attack"));

    private static final SelenideElement restoreBtn = $(byText("Restore"));

    TiwarAttributes tiwarAttributes = TiwarAttributes.getInstance(); 
    @Override
    protected String url() {
        return "/arena";
    }

    public void runTasks() {
        LOGGER.info("Arena");
        open(url());
        if (tiwarAttributes.getHealth() < 1500 && tiwarAttributes.getStamina() < 50) {
            LOGGER.info("Skip Arena");
            return;
        }
        LOGGER.info("Attack in Arena");
        while (!restoreBtn.exists()) {
            attackBtn.click();
        }
        TASK_STATE.setLastExecuted(LocalDateTime.now());
        TASK_STATE.setNextExecution(LocalDateTime.now().plusMinutes(5));
    }


}