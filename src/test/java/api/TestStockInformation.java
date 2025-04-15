package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import rest.model.Product;
import rest.service.StockService;

import static org.assertj.core.api.Assertions.assertThat;

public class TestStockInformation {
    StockService stockService = new StockService();

    @Test
    public void getProductStockInformation() {
        Product productData = Product.builder()
                .productId(1321665)
                .inStock(true)
                .premiumOnly(false)
                .build();

        Response response = stockService.getProductStock(productData.getProductId());

        response.then()
                .log()
                .all()
                .statusCode(200);

        Product actual = response.as(Product.class);

        assertThat(actual.getProductId()).isEqualTo(productData.getProductId());
        assertThat(actual.isInStock()).isEqualTo(productData.isInStock());
        assertThat(actual.isPremiumOnly()).isEqualTo(productData.isPremiumOnly());
    }
}
