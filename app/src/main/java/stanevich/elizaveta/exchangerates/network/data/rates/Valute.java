package stanevich.elizaveta.exchangerates.network.data.rates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


// Currency :)
public class Valute {
    @SerializedName("ID")
    @Expose
    private int id;

    @SerializedName("NumCode")
    @Expose
    private int numCode;

    @SerializedName("CharCode")
    @Expose
    private String charCode;

    @SerializedName("Nominal")
    @Expose
    private String nominal;

    @SerializedName("Name")
    @Expose
    private int nameNom;

    @SerializedName("Value")
    @Expose
    private int value;

    @SerializedName("Previous")
    @Expose
    private String previous;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public int getNameNom() {
        return nameNom;
    }

    public void setNameNom(int nameNom) {
        this.nameNom = nameNom;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}

