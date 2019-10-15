package stanevich.elizaveta.exchangerates.model.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class TransactionHistory {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("amount")
    @Expose
    private double amount;

    public String getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(String convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    private String convertedAmount = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String formattedAmount() {
        String minus = amount < 0 ? "-" : "";
        return minus + "$" + Math.abs(amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistory that = (TransactionHistory) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(iconUrl, that.iconUrl) &&
                Objects.equals(date, that.date) &&
                convertedAmount.equals(that.convertedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, iconUrl, date, amount, convertedAmount);
    }
}
