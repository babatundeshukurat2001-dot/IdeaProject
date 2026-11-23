import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private final ShoppingCart shoppingCart;
    private final List<BillingInformation> billingInformationList;

    public Customer(int age, String email,
                    Address homeAddress, String name,
                    String password, String phone) {

        super(age, email, homeAddress, name, password, phone);

        this.shoppingCart = new ShoppingCart();

        this.billingInformationList = new ArrayList<>();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<BillingInformation> getBillingInformationList() {
        return billingInformationList;
    }

    public void addBillingInformation(
            BillingInformation billingInformation) {

        billingInformationList.add(billingInformation);
    }
}