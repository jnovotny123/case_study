package rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private int productId;
    private int warehouseId;
    private boolean inStock;
    private boolean premiumOnly;

    private String productName;
    private String productFullName;
    private BigDecimal unitPrice;
    private int quantity;
}
