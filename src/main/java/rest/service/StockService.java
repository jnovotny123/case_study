package rest.service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StockService {
    private static final String BASE_URL = "https://www.rohlik.cz/api/v1";

    public StockService() {
    }

    public Response getProductStock(int productId) {
        Response response = given()
                .log()
                .all()
                .baseUri(BASE_URL)
                .when()
                .get("/products/" + productId + "/stock");
        return response;
    }
}
