package stanevich.elizaveta.exchangerates.network.data.rates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ExchangeRatesProperty {
    @SerializedName("Date")
    @Expose
    private int dateExRat;

    @SerializedName("PreviousDate")
    @Expose
    private int previousDateExRat;

    @SerializedName("PreviousURL")
    @Expose
    private String previousURL;

    @SerializedName("Timestamp")
    @Expose
    private String timestamp;

    @SerializedName("Valute")
    @Expose
    private Map<String, ValuteProperty> valutePropertyMap;

    public int getDateExRat() {
        return dateExRat;
    }

    public void setDateExRat(int dateExRat) {
        this.dateExRat = dateExRat;
    }

    public int getPreviousDateExRat() {
        return previousDateExRat;
    }

    public void setPreviousDateExRat(int previousDateExRat) {
        this.previousDateExRat = previousDateExRat;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, ValuteProperty> getValutePropertyMap() {
        return valutePropertyMap;
    }

    public void setValutePropertyMap(Map<String, ValuteProperty> valutePropertyMap) {
        this.valutePropertyMap = valutePropertyMap;
    }
}
