import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
public class EStoreTest {

    private Customer customer;
    private Product product;

    @BeforeEach
    void setUp() {

        Address address = new Address(
                "Abeokuta",
                "Nigeria",
                "12",
                "Oke-Ilewo Road",
                "Ogun"
        );

        customer = new Customer(
                25,
                "customer@example.com",
                address,
                "Ada",
                "password123",
                "08012345678"
        );

        product = new Product(
                1,
                "Laptop",
                new BigDecimal("750000"),
                "A laptop computer",
                ProductCategory.ELECTRONICS
        );
    }

    @Test
    void customerShouldHaveAnEmptyShoppingCartAtStart() {

        assertEquals(
                0,
                customer.getShoppingCart().getItems().size()
        );
    }

    @Test
    void shouldAddItemToShoppingCart() {

        Item item = new Item(product, 2);

        customer.getShoppingCart().addItem(item);

        assertEquals(
                1,
                customer.getShoppingCart().getItems().size()
        );
    }

    @Test
    void shouldRemoveItemFromShoppingCart() {

        Item item = new Item(product, 2);

        customer.getShoppingCart().addItem(item);

        customer.getShoppingCart().removeItem(item);

        assertEquals(
                0,
                customer.getShoppingCart().getItems().size()
        );
    }

    @Test
    void itemShouldHaveCorrectQuantity() {

        Item item = new Item(product, 3);

        assertEquals(3, item.getQuantity());
    }

    @Test
    void shouldNotAcceptZeroQuantity() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Item(product, 0)
        );
    }

    @Test
    void customerShouldAcceptBillingInformation() {

        CreditCard card = new CreditCard(
                "123",
                2028,
                10,
                "0000000000000000",
                "Ada Example",
                CardType.VISA_CARD
        );

        BillingInformation billing = new BillingInformation(
                "08012345678",
                "Ada Example",
                customer.getHomeAddress(),
                card
        );

        customer.addBillingInformation(billing);

        assertEquals(
                1,
                customer.getBillingInformationList().size()
        );
    }
}