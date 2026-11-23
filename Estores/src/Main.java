import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Address home = new Address(
                "Abeokuta",
                "Nigeria",
                "12",
                "Oke-Ilewo Road",
                "Ogun"
        );

        Customer customer = new Customer(
                25,
                "customer@example.com",
                home,
                "Ada",
                "password123",
                "08012345678"
        );

        Product laptop = new Product(
                1,
                "Laptop",
                new BigDecimal("750000.00"),
                "A laptop computer",
                ProductCategory.ELECTRONICS
        );
        Item laptopItem = new Item(laptop, 2);

        customer.getShoppingCart().addItem(laptopItem);

        Address delivery = new Address(
                "Lagos",
                "Nigeria",
                "5",
                "Allen Avenue",
                "Lagos"
        );

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
                delivery,
                card
        );

        customer.addBillingInformation(billing);

        System.out.println("Customer: " + customer.getName());

        System.out.println(
                "Items in cart: " +
                        customer.getShoppingCart().getItems().size()
        );

        System.out.println(
                "Product: " +
                        laptopItem.getProduct().getProductName()
        );

        System.out.println(
                "Quantity: " + laptopItem.getQuantity()
        );

        System.out.println(
                "Category: " + laptop.getCategory()
        );
    }
}