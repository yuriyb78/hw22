package tests;

import extensions.WithLogin;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import pages.component.CheckProfilePage;


public class CheckProfilePageTest extends BaseTests {

    ProfilePage profilePage = new ProfilePage();
    CheckProfilePage checkProfilePage= new CheckProfilePage();

    @Test
    @WithLogin
    @Feature("Проверка страницы профиля пользователя")
    void checkEmptyTableOnProfilePageTest () {

        profilePage.openProfilePage();
        checkProfilePage.checkUserNameAfterAuthorisation()
                .checkEmptyCellsInList()
                .checkEmptyTable();

    }
}
