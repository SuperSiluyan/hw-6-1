import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Test1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";

        //Опционально, для отладки
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void selenideCode() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("soft");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $x("//*[@id=\"wiki-pages-box\"]/div/div[2]/ul/li[17]/details/summary/div/div").click();
        $$("li.my-2").findBy(text("Using JUnit5")).click();
        $$("div .highlight").get(4).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

}
