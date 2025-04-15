package ui.page_components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginForm {
    private final SelenideElement root = $("form[data-test='user-login-form']");

    public SelenideElement getEmailInput() {
        return root.$("#email");
    }

    public SelenideElement getPasswordInput() {
        return root.$("#password");
    }

    public SelenideElement getLoginButton() {
        return root.$("button[data-test='btnSignIn']");
    }

    public void login(String email, String password) {
        getEmailInput().setValue(email);
        getPasswordInput().setValue(password);
        getLoginButton().click();
    }
}
