package ui.page_objects;

import com.codeborne.selenide.SelenideElement;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private SelenideElement productCard;

    public HomePage waitForUserIconVisible() {
        $("[data-test='header-user-icon']").shouldBe(visible);
        return this;
    }

    public HomePage searchFor(String query) {
        $("#searchGlobal").setValue(query);
        $("button[data-test='header-search-button']").click();
        return this;
    }

    public HomePage addToCart(String productFullName, int quantity) {
        String ariaLabelText = "Přidat jeden kus. " + productFullName;

        // Najdi tlačítko, jehož aria-label obsahuje název produktu
        SelenideElement plusButton = $$("button[aria-label]")
                .findBy(attributeMatching("aria-label", ".*" + Pattern.quote(productFullName) + ".*"))
                .shouldBe(visible);

        for (int i = 0; i < quantity; i++) {
            plusButton.click();
        }

        return this;
    }

    public CartPage openCart() {
        $("[data-test='cart-header-wrapper']").shouldBe(visible).click();
        return new CartPage();
    }
}
