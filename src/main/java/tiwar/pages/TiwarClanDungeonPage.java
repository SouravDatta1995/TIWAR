package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

// page_url = http://tiwar.net/clandungeon/
public class TiwarClanDungeonPage extends TiwarBasePage {

    private static TiwarClanDungeonPage instance;

    private TiwarClanDungeonPage() {
    }

    public static synchronized TiwarClanDungeonPage getInstance() {
        if (instance == null) {
            instance = new TiwarClanDungeonPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarClanDungeonPage.class);
    private static final SelenideElement linkAttackMonster = $x("//a[contains(@href,'/clandungeon/attack/')]");

    private static final SelenideElement closeDungeon = $x("//a[@href='/clandungeon/?close']");

    @Override
    public String url() {
        return "/clandungeon";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Clan Dungeon");
        open(url());
        while (linkAttackMonster.exists()) {
            linkAttackMonster.click();
        }
        if(closeDungeon.exists()) {
            closeDungeon.click();
        }
    }
}