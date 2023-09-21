import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverSolution {


    @Test
    void hoverSolutionToEnterprize() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $(withText("Solutions")).hover();
        $(byText("Enterprise")).shouldBe(Condition.visible);
        $(byText("Enterprise")).click();
        $(".enterprise-hero").shouldHave(Condition.text("Build like the best"));


    }

}
