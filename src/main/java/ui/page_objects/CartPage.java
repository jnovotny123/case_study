package ui.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public CartPage assertProductAndQuantity(String productName, int expectedQuantity) {
        // Najdi odkaz s názvem produktu
        SelenideElement productLink = $$("a").findBy(text(productName))
                .shouldBe(visible);

        // Najdi nadřazený prvek, který obsahuje input s množstvím
        SelenideElement quantityInput = $("input[data-test='counter-input']")
                .shouldBe(visible);

        // Ověř, že hodnota inputu odpovídá očekávanému množství
        quantityInput.shouldHave(value(String.valueOf(expectedQuantity)));

        return this;
    }

}
