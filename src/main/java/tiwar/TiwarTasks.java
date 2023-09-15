package tiwar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
