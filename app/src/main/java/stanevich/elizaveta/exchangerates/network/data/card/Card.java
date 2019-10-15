package stanevich.elizaveta.exchangerates.network.data.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Card {
    @SerializedName("card_number")
    @Expose
    private int cardNumber;

    @SerializedName("cardholder_name")
    @Expose
    private int cardholderName;

    @SerializedName("valid")
    @Expose
    private String valid;

    @SerializedName("balance")
    @Expose
    private String balance;

    @SerializedName("transaction_history")
    @Expose
    private List<TransactionHistory> transactionHistoryList;

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(int cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
