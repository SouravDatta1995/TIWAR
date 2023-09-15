package tiwar.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.interfaces.TiwarBasePage;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

// page_url = http://tiwar.net/
public class TiwarLoginPage extends TiwarBasePage {

    private static TiwarLoginPage instance;

    private TiwarLoginPage() {
    }

    public static synchronized TiwarLoginPage getInstance() {
        if (instance == null) {
            instance = new TiwarLoginPage();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarLoginPage.class);
    public SelenideElement signIn = $x("//a[contains(@href, '/?sign_in=1')]");
    public SelenideElement login = $x("//*[@id='login']");
    public SelenideElement pass = $x("//input[@name='pass']");
    public SelenideElement loginBtn = $x("//input[@type='submit']");

    @Override
    public String url() {
        return "/";
    }

    @Override
    public void runTasks() {
        LOGGER.info("Login");
        TASK_STATE.setNextExecution(LocalDateTime.now());
        open("/");
        signIn.click();
        login.sendKeys("Spoilersd");
        pass.sendKeys("orG3GbM2");
        loginBtn.click();
        TASK_STATE.setShouldExecute(false);
    }
}
