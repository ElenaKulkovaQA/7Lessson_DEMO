package pages.components;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {


    public CheckResultComponent checkResult(String resultName, String resultValue) {

        String locator = "//*[contains(text(),'" + resultName + "')]/../td[2]";

        $x(locator).shouldHave(Condition.text(resultValue));

        return this;
    }


}



