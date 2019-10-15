package stanevich.elizaveta.exchangerates.model.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Card {
    @SerializedName("card_number")
    @Expose
    private String cardNumber = "";

    @SerializedName("cardholder_name")
    @Expose
    private String cardholderName;

    @SerializedName("valid")
    @Expose
    private String valid;

    @SerializedName("balance")
    @Expose
    private double balance = 0.0;

    @SerializedName("transaction_history")
    @Expose
    private List<TransactionHistory> transactionHistoryList = new ArrayList<>();

    public String getConvertedBalance() {
        return convertedBalance;
    }

    public void setConvertedBalance(String convertedBalance) {
        this.convertedBalance = convertedBalance;
    }

    private String convertedBalance;

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

    public double getBalance() {
        return balance;
    }

    public String formattedBalance() {
        String minus = balance < 0 ? "-" : "";
        return minus + "$" + Math.abs(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
