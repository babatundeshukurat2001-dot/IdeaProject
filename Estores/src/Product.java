import java.math.BigDecimal;

public class Product {

    private int productId;
    private String productName;
    private BigDecimal price;
    private String productDescription;
    private ProductCategory category;

    public Product(int productId, String productName,
                   BigDecimal price, String productDescription,
                   ProductCategory category) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}

