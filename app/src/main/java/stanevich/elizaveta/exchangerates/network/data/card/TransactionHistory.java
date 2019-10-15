package stanevich.elizaveta.exchangerates.network.data.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionHistory {

    @SerializedName("title")
    @Expose
    private int title;

    @SerializedName("icon_url")
    @Expose
    private int icon_url;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("amount")
    @Expose
    private String amount;

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(int icon_url) {
        this.icon_url = icon_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
