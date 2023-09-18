import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class test1 {

    @BeforeAll
    static void beforeAll()
    {
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void selenideCode() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".internal present"),$(byText("Soft assertions")).shouldBe(Visible);
        $(".internal present"),$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").shouldHave(Condition.text("3. Using JUnit5 extend test class:");
    }

}
