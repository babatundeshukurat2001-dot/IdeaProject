package UserPackage;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<BillingInformation> billingInformationList;
    private ShoppingCart shoppingCart;

    public Customer(int age, String email, String homeAddress, String name, String password, String phone, List<BillingInformation> billingInformationList, ShoppingCart shoppingCart) {
        super(age, email, homeAddress, name, password, phone);
        this.billingInformationList = new ArrayList<>();
        this.shoppingCart = shoppingCart;
    }

    public List<BillingInformation> getBillingInformationList() {
        return billingInformationList;
    }

    public void setBillingInformationList(List<BillingInformation> billingInformationList) {
        this.billingInformationList = billingInformationList;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}