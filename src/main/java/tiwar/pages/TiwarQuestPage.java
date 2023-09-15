package tiwar.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://tiwar.net/quest/
public class TiwarQuestPage extends TiwarBasePage {

    private static TiwarQuestPage instance;

    private TiwarQuestPage() {
    }

    public static synchronized TiwarQuestPage getInstance() {
        if (instance == null) {
            instance = new TiwarQuestPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarQuestPage.class);
    public final SelenideElement linkOpenKey = $x("//a[contains(@href, '/quest/openChest/1/?r=44117849')]");
    private final ElementsCollection completedQuests = $$x("//a[contains(@href, '/quest/end')]");

    @Override
    public String url() {
        return "/quest";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Quest");
        open(url());
        while (!completedQuests.isEmpty()) {
            completedQuests.asDynamicIterable().forEach(SelenideElement::click);
        }
        if (linkOpenKey.exists()) {
            linkOpenKey.click();
        }
    }
}