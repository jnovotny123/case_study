package ui.page_objects;

import com.codeborne.selenide.SelenideElement;
import utils.UserData;
import ui.page_components.LoginForm;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement openLoginFormButton = $x("//p[text()='Přihlásit se' and contains(@class, 'tw-hidden')]");
    private final LoginForm loginForm = new LoginForm();

    public LoginPage openLoginForm() {
        openLoginFormButton.click();
        return this;
    }

    public HomePage login(UserData user) {
        openLoginForm();
        loginForm.login(user.getEmail(), user.getPassword());
        return new HomePage(); // předpokládám, že HomePage nevyžaduje driver
    }
}
