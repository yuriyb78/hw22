package extensions;

import config.AuthConfig;
import io.qameta.allure.Step;
import model.LoginBodyModel;
import model.LoginResponseModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.requestSpec;
import static specs.RequestSpec.successfulResponseSpec;

public class LoginExtension implements BeforeEachCallback {
    @Override
    @Step("Авторизация на сайте https://demoqa.com через API")
    public void beforeEach (ExtensionContext context) {

        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);

        LoginBodyModel loginBodyModel = new LoginBodyModel();
        loginBodyModel.setUserName(authConfig.userName());
        loginBodyModel.setPassword(authConfig.password());

        LoginResponseModel response = given(requestSpec)
                .body(loginBodyModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successfulResponseSpec)
                .extract().as(LoginResponseModel.class);

        // Установка куки авторизации на сайте
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
    }
}
