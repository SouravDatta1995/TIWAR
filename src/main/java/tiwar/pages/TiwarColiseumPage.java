package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://tiwar.net/coliseum/
public class TiwarColiseumPage extends TiwarBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarUndyingPage.class);
    private static final int MAX_COLISEUM_COUNT = 5;
    private int MAX_HEALTH = 5000;
    private static final SelenideElement toQueue = $x("//a[contains(@href, '/coliseum/enterFight')]");
    private static final SelenideElement refresh = $x("//a[@href= '/coliseum/']");
    private static final SelenideElement linkDodge = $x("//a[contains(@href, '/coliseum/dodge')]");
    private static final SelenideElement linkAttack = $x("//a[contains(@href, '/coliseum/atk')]");
    private static final SelenideElement linkChangeTarget = $x("//a[contains(@href, '/coliseum/atkrnd')]");
    private static final SelenideElement linkTincture = $x("//a[contains(@href, '/coliseum/heal')]");
    private static final SelenideElement spanHealthOK = $("div[class$='w50'] span[class='nwr']");
    private static final SelenideElement spanHealthDRED = $x("//span[@class='dred']");
    private static final SelenideElement opponentHealth = $x("/html/body/div/div[1]/div[3]/div[1]/span");
    private static TiwarColiseumPage instance;
    private static int COLISEUM_COUNT = 0;

    public SelenideElement spanTimer = $x("//span[@class='dgreen medium']");

    private TiwarColiseumPage() {
    }

    public static synchronized TiwarColiseumPage getInstance() {
        if (instance == null) {
            instance = new TiwarColiseumPage();
        }
        return instance;
    }

    @Override
    protected String url() {
        return "/coliseum";
    }

    @Override
    public void runTasks() {
        open(url());
        LOGGER.info("Coliseum");
        if (toQueue.exists()) {
            LOGGER.info("Coliseum - To Queue");
            toQueue.click();
        }
        try {
            while (refresh.exists()) {
                LOGGER.info("Coliseum - Refresh");
                refresh.click();
                TimeUnit.SECONDS.sleep(2);
            }
            boolean healthCheckFlag = true;
            while (linkAttack.exists()) {
                LOGGER.info("Coliseum - STAGE");
                if (Integer.parseInt(opponentHealth.getText().trim()) <= 500) {
                    LOGGER.info("Coliseum - Attack");
                    linkAttack.click();
                } else {
                    LOGGER.info("Coliseum - Change Target");
                    linkChangeTarget.click();
                }
                if (spanHealthOK.exists()) {
                    var currHealth = Integer.parseInt(spanHealthOK.getText());
                    if(healthCheckFlag) {
                        MAX_HEALTH = currHealth;
                        healthCheckFlag = false;
                    }
                    if(currHealth <= MAX_HEALTH/2) {
                        linkTincture.click();
                    }
                    LOGGER.info("Coliseum - Health OK {}", currHealth);
                } else if (spanHealthDRED.exists() && linkDodge.exists()) {
                    LOGGER.info("Coliseum - Health LOW {}", spanHealthDRED.getText());
                    linkDodge.click();
                    linkTincture.click();
                    linkAttack.click();
                    TimeUnit.SECONDS.sleep(2);
                    continue;
                }
                TimeUnit.SECONDS.sleep(4);
            }
            ++COLISEUM_COUNT;
            LOGGER.info("Coliseum Count {}", COLISEUM_COUNT);
            TASK_STATE.setLastExecuted(LocalDateTime.now());
            if (COLISEUM_COUNT > MAX_COLISEUM_COUNT &&
                    TASK_STATE.getNextExecution().isBefore(LocalDateTime.now())) {
                COLISEUM_COUNT = 1;
            }
            if (COLISEUM_COUNT > MAX_COLISEUM_COUNT) {
                TASK_STATE.setNextExecution(LocalDateTime.now().plusHours(1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}