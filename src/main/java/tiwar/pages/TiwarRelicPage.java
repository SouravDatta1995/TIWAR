package tiwar.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

// page_url = http://tiwar.net/relic/
public class TiwarRelicPage extends TiwarBasePage {

    private static TiwarRelicPage instance;

    private TiwarRelicPage() {
    }

    public static synchronized TiwarRelicPage getInstance() {
        if (instance == null) {
            instance = new TiwarRelicPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarRelicPage.class);
    private final ElementsCollection linkReceiveReward = $$x("//a[contains(@href, '/relic/reward')]");

    @Override
    public String url() {
        return "/relic";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Relic");
        open(url());
        while (!linkReceiveReward.isEmpty()) {
            linkReceiveReward.asDynamicIterable().forEach(SelenideElement::click);
        }
    }
}