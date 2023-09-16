package tiwar;

import com.codeborne.selenide.Configuration;
import tiwar.pages.*;

import java.util.TimerTask;


public class TiwarTasks extends TimerTask {

    TiwarLoginPage loginPage = TiwarLoginPage.getInstance();
    TiwarArenaPage arenaPage = TiwarArenaPage.getInstance();
    TiwarCavePage cavePage = TiwarCavePage.getInstance();
    TiwarQuestPage questPage = TiwarQuestPage.getInstance();
    TiwarCampaignPage campaignPage = TiwarCampaignPage.getInstance();
    TiwarClanDungeonPage clandungeonPage = TiwarClanDungeonPage.getInstance();
    TiwarRelicPage relicPage = TiwarRelicPage.getInstance();
    TiwarCareerPage careerPage = TiwarCareerPage.getInstance();

    TiwarColiseumPage coliseumPage = TiwarColiseumPage.getInstance();

    TiwarAttributes tiwarAttributes = TiwarAttributes.getInstance();

    public TiwarTasks(String browser, String headless, String driverPath) {
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);
        if(driverPath != null)
            System.setProperty("webdriver.gecko.driver", driverPath);
    }

    @Override
    public void run() {
        loginPage.run();
        if(!tiwarAttributes.isUpcomingBattle()) {
            tiwarAttributes.getHealth();
            tiwarAttributes.getStamina();
            tiwarAttributes.isUpcomingBattle();

            arenaPage.run();
            cavePage.run();
            questPage.run();
            relicPage.run();
            campaignPage.run();
            careerPage.run();
            clandungeonPage.run();
            coliseumPage.run();
            tiwarAttributes.reset();
        }
    }
}
