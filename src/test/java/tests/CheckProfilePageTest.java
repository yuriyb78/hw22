package tests;

import config.AuthConfig;
import extensions.WithLogin;
import model.LoginBodyModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import pages.component.CheckProfilePage;


public class CheckProfilePageTest extends BaseTests {

    ProfilePage profilePage = new ProfilePage();
    CheckProfilePage checkProfilePage= new CheckProfilePage();

    @Test
    @WithLogin
    void checkProfilePageTest () {

        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
        profilePage.openProfilePage();
        checkProfilePage.checkUserNameAfterAuthorisation(authConfig.userName());



    }
}
