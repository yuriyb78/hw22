package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    @Step("Открытие страницы профиля пользователя")
    public void openProfilePage () {
        open("/profile");
    }

}
