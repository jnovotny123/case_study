package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.*;

public class RohlikTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

        // volitelné: aby se načetl WebDriver
        open("about:blank");
    }

    @AfterMethod
    public void tearDown() {
        String close = System.getProperty("closeBrowser", "true");

        if (Boolean.parseBoolean(close)) {
            System.out.println("🧹 Ukončuji prohlížeč (closeBrowser=true)");
            WebDriverRunner.closeWebDriver();
        } else {
            System.out.println("🛑 Prohlížeč zůstává otevřený (closeBrowser=false)");
        }
    }
}
