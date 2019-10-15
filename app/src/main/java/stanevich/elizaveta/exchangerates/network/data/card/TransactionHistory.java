package stanevich.elizaveta.exchangerates.network.data.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionHistory {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("icon_url")
    @Expose
    private String icon_url;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("amount")
    @Expose
    private String amount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
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
