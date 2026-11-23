public class BillingInformation {

    private String receiverPhoneNumber;
    private String receiverName;
    private Address deliveryAddress;
    private CreditCard creditCard;

    public BillingInformation(String receiverPhoneNumber,
                              String receiverName,
                              Address deliveryAddress,
                              CreditCard creditCard) {

        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverName = receiverName;
        this.deliveryAddress = deliveryAddress;
        this.creditCard = creditCard;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}