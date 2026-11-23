public class CreditCard {

    private String cvv;
    private int expirationYear;
    private int expirationMonth;
    private String cardNumber;
    private String nameOnCard;
    private CardType cardType;

    public CreditCard(String cvv, int expirationYear,
                      int expirationMonth, String cardNumber,
                      String nameOnCard, CardType cardType) {

        this.cvv = cvv;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cardType = cardType;
    }

    public String getCvv() {
        return cvv;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public CardType getCardType() {
        return cardType;
    }
}