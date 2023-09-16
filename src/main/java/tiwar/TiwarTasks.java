package tiwar;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        if(driverPath != null) {
            System.setProperty("webdriver.gecko.driver", driverPath);
            WebDriver driver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);

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
