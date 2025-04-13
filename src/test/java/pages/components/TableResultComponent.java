package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class TableResultComponent {
     public void checkResultTable(String key, String value){
        $(".modal-content").$(byText(key)).parent().shouldHave(text(value));
     }
}

