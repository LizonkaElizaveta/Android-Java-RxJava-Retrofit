package stanevich.elizaveta.exchangerates.network.data.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Card {
    @SerializedName("card_number")
    @Expose
    private String cardNumber = "1234 5432 2345 5322";

    @SerializedName("cardholder_name")
    @Expose
    private String cardholderName;

    @SerializedName("valid")
    @Expose
    private String valid;

    @SerializedName("balance")
    @Expose
    private String balance = "0.00";

    @SerializedName("transaction_history")
    @Expose
    private List<TransactionHistory> transactionHistoryList;

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getBalance() {
        return "$" + balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
