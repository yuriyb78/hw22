package pages.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckProfilePage {

    public final SelenideElement noRowFound = $(".rt-noData"),
                                userNameSelector = $("#userName-value");

    public CheckProfilePage checkEmptyTable () {
        noRowFound.shouldBe(Condition.visible);
        return this;
    }

    public CheckProfilePage checkUserNameAfterAuthorisation (String userName) {
        userNameSelector.shouldHave(text(userName));
        return this;
    }
}
