package gui;

import org.testng.annotations.Test;
import rest.model.Product;
import utils.UserData;
import ui.page_objects.LoginPage;
import utils.CookieBannerHandler;
import utils.RohlikTest;

import static com.codeborne.selenide.Selenide.open;


public class TestAddToBasket extends RohlikTest {

    @Test
    public void testAddProductToBasket() {
        UserData user = UserData.builder()
                .email("rohliktest2025@gmail.com")
                .password("rohlikrohlicek")
                .build();

        Product product = Product.builder()
                .productName("máslo")
                .productFullName("Milko Máslo")
                .quantity(3)
                .build();

        open("https://www.rohlik.cz");

        new CookieBannerHandler().acceptCookies();

        new LoginPage().login(user)
                .waitForUserIconVisible()
                .searchFor(product.getProductName())
                .addToCart(product.getProductFullName(), product.getQuantity())
                .openCart()
                .assertProductAndQuantity(product.getProductFullName(), product.getQuantity());
    }
}
