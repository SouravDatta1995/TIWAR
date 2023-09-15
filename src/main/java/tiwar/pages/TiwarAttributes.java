package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TiwarAttributes {

    private static TiwarAttributes instance;

    private TiwarAttributes() {
    }

    public static synchronized TiwarAttributes getInstance() {
        if (instance == null) {
            instance = new TiwarAttributes();
        }
        return instance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarAttributes.class);
    private static final SelenideElement staminaAmt = $x("//span[@class='bl rght nwr']");
    private static final SelenideElement healthAmt = $x("//span[@class='bl rght nwr']//span");
    private static final SelenideElement upcomingBattle = $x("//a[.//img[@src='/images/icon/2hit.png']]");

    public int getHealth() {
        String health = healthAmt.getText().trim();
        LOGGER.info("Health : {}",health);
        return Integer.parseInt(health);
    }

    public int getStamina() {
        String stamina = staminaAmt.getText().split("\\| ")[1].trim();
        LOGGER.info("Stamina : {}",stamina);
        return Integer.parseInt(stamina);
    }

    public boolean isUpcomingBattle() {
        boolean res = upcomingBattle.exists();
        LOGGER.info("Upcoming Battle : {}",String.valueOf(res));
        return res;
    }

    public void reset() {
        open("/");
    }

}