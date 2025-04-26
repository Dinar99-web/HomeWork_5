import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubEnterprizeTest {
    @BeforeAll
    static void BrowserSetup(){
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void openEnterpizePage(){
        open("https://github.com/");
        $$(".HeaderMenu-link").findBy(Condition.text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(Condition.text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
