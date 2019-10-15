package stanevich.elizaveta.exchangerates.network.data.rates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


// Currency :)
public class Valute {
    @SerializedName("ID")
    @Expose
    private String id;

    @SerializedName("NumCode")
    @Expose
    private String numCode;

    @SerializedName("CharCode")
    @Expose
    private String charCode;

    @SerializedName("Nominal")
    @Expose
    private int nominal;

    @SerializedName("Name")
    @Expose
    private String nameNom;

    @SerializedName("Value")
    @Expose
    private double value;

    @SerializedName("Previous")
    @Expose
    private String previous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getNameNom() {
        return nameNom;
    }

    public void setNameNom(String nameNom) {
        this.nameNom = nameNom;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}

