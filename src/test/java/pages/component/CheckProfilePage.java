package pages.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.AuthConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckProfilePage {

    private final SelenideElement noRowFound = $(".rt-noData"),
                                userNameSelector = $("#userName-value");

    private ElementsCollection listCells = $$("[role=gridcell]");

    @Step("Проверка успешной авторизации припереходе на страницу профиля пользователя")
    public CheckProfilePage checkUserNameAfterAuthorisation () {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
        userNameSelector.shouldHave(text(authConfig.userName()));
        return this;
    }

    @Step("Проверка что поля таблицы пустые")
    public CheckProfilePage checkEmptyCellsInList() {
        for (SelenideElement cell : listCells) {
            cell.shouldHave(Condition.empty);
        }
        return this;
    }
    @Step("Проверка сообщения об отсуствии записей в таблицу")
    public CheckProfilePage checkEmptyTable () {
        noRowFound.shouldBe(Condition.visible);
        return this;
    }


}
