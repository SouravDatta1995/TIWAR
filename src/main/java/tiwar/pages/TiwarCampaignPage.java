package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://tiwar.net/campaign/
public class TiwarCampaignPage extends TiwarBasePage {

    private static TiwarCampaignPage instance;
    private TiwarCampaignPage() {
    }
    public static synchronized TiwarCampaignPage getInstance() {
        if(instance == null) {
            instance = new TiwarCampaignPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarCampaignPage.class);
    private final SelenideElement linkCamping = $x("//a[contains(@href, '/campaign/go/')]");
    private final SelenideElement linkFight = $x("//a[contains(@href, '/campaign/fight/')]");
    private final SelenideElement linkAttack = $x("//a[contains(@href, '/campaign/attack/')]");
    private final SelenideElement linkBackCampaign = $x("//a[contains(@href, '/campaign/end/')]");

    @Override
    public String url() {
        return "/campaign";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Campaign");
        open(url());
        for (int i = 0; i < 3; i++) {
            if(linkCamping.exists()) {
                linkCamping.click();
            }
            if(linkFight.exists()) {
                linkFight.click();
                while (linkAttack.exists()) {
                    linkAttack.click();
                }
            }
            while(linkAttack.exists()) {
                linkAttack.click();
            }
            if(linkBackCampaign.exists()) {
                linkBackCampaign.click();
            }
        }

    }
}