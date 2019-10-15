package stanevich.elizaveta.exchangerates.network.data.rates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

public class ExchangeRate {
    @SerializedName("Date")
    @Expose
    private Date dateExRat;

    @SerializedName("PreviousDate")
    @Expose
    private Date previousDateExRat;

    @SerializedName("PreviousURL")
    @Expose
    private String previousURL;

    @SerializedName("Timestamp")
    @Expose
    private Date timestamp;

    @SerializedName("Valute")
    @Expose
    private Map<String, Valute> valuteMap;


    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public Date getDateExRat() {
        return dateExRat;
    }

    public void setDateExRat(Date dateExRat) {
        this.dateExRat = dateExRat;
    }

    public Date getPreviousDateExRat() {
        return previousDateExRat;
    }

    public void setPreviousDateExRat(Date previousDateExRat) {
        this.previousDateExRat = previousDateExRat;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Valute> getValuteMap() {
        return valuteMap;
    }

    public void setValuteMap(Map<String, Valute> valuteMap) {
        this.valuteMap = valuteMap;
    }
}
