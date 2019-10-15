package stanevich.elizaveta.exchangerates.overview;

public enum CurrencyType {
    GBP, EUR, RUB, USD;

    public String getSymbol() {
        switch (this) {
            case EUR:
                return "€";
            case GBP:
                return "£";
            case RUB:
                return "\u20BD";
            case USD:
                return "$";
            default:
                return "$";
        }
    }
}

