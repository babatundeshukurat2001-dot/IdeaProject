package UserPackage;

public class BillingInformation {
    private String receiverPhone;
    private String receiverName;
    private Address deliveryAddress;
    private CreditCardInfo creditCardInfo;

    public BillingInformation(String receiverPhone, String receiverName, Address deliveryAddress, CreditCardInfo creditCardInfo) {
        this.receiverPhone = receiverPhone;
        this.receiverName = receiverName;
        this.deliveryAddress = deliveryAddress;
        this.creditCardInfo = creditCardInfo;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    @Override
    public String toString() {
        return "BillingInformation{" +
                "receiverPhone='" + receiverPhone + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                ", creditCardInfo=" + creditCardInfo +
                '}';
    }
}
