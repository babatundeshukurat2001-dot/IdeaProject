package UserPackage;

public class CreditCardInfo {
    private String cardCvv;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String creditCardNumber;
    private String nameOnCard;
    private CardType cardType;

    public CreditCardInfo(String cardCvv, int cardExpirationYear, int cardExpirationMonth, String creditCardNumber, String nameOnCard, CardType cardType) {
        this.cardCvv = cardCvv;
        this.cardExpirationYear = cardExpirationYear;
        this.cardExpirationMonth = cardExpirationMonth;
        this.creditCardNumber = creditCardNumber;
        this.nameOnCard = nameOnCard;
        this.cardType = cardType;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public int getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardExpirationYear(int cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public int getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(int cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CreditCardInfo{" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", cardType=" + cardType +
                '}';
    }
}
