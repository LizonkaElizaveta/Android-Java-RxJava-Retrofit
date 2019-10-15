package stanevich.elizaveta.exchangerates.overview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stanevich.elizaveta.exchangerates.network.data.card.Card;
import stanevich.elizaveta.exchangerates.network.data.card.TransactionHistory;
import stanevich.elizaveta.exchangerates.network.data.rates.ExchangeRate;
import stanevich.elizaveta.exchangerates.network.data.rates.Valute;
import stanevich.elizaveta.exchangerates.network.service.CardApiService;
import stanevich.elizaveta.exchangerates.network.service.ExchangeRatesApiService;

public class OverviewViewModel extends ViewModel {


    private final MutableLiveData<Card> _card = new MutableLiveData<>(new Card());
    private final MutableLiveData<ExchangeRate> _exchangeRates = new MutableLiveData<>(new ExchangeRate());
    private final MutableLiveData<Status> _status = new MutableLiveData<>();
    private final MutableLiveData<CurrencyType> _currentCurrencyType = new MutableLiveData<>(CurrencyType.GBP);


    public OverviewViewModel() {
        requestCard();
        requestExchange();
        _exchangeRates.observeForever(convertCurrency());
        _card.observeForever(convertCurrency());
        _currentCurrencyType.observeForever(convertCurrency());
    }

    private <T> Observer<T> convertCurrency() {
        return new Observer<T>() {
            @Override
            public void onChanged(T exchangeRate) {
                Card card = _card.getValue();
                if (card != null) {
                    card.setConvertedBalance(formatCurrency(card.getBalance()));
                    for (TransactionHistory th : card.getTransactionHistoryList()) {
                        th.setConvertedAmount(formatCurrency(th.getAmount()));
                    }
                }
                _card.postValue(card);
            }
        };
    }

    private double getCurrencyMultiplier(CurrencyType currencyType) {
        ExchangeRate value = _exchangeRates.getValue();
        if (value != null) {
            Map<String, Valute> valutes = value.getValuteMap();
            if (valutes != null) {
                Valute current = valutes.get(currencyType.toString());
                Valute usd = valutes.get(CurrencyType.USD.toString());
                if (currencyType == CurrencyType.RUB && usd != null) {
                    return usd.getValue();
                } else if (current != null && usd != null) {
                    return usd.getValue() / current.getNominal() / current.getValue();
                }
            }
        }
        return 1.0;
    }

    public String formatCurrency(double value) {
        CurrencyType currencyType = _currentCurrencyType.getValue();
        NumberFormat formatter = new DecimalFormat(currencyType.getSymbol() + "0.00");
        double absValue = Math.abs(value);

        return formatter.format(absValue * getCurrencyMultiplier(currencyType));
    }

    public LiveData<Card> getCardLiveData() {
        return _card;
    }

    public LiveData<ExchangeRate> getExchangeRateLiveData() {
        return _exchangeRates;
    }

    public LiveData<CurrencyType> getCurrentCurrencyType() {
        return _currentCurrencyType;
    }

    public void setCurrencyType(String currencyType) {
        _currentCurrencyType.setValue(CurrencyType.valueOf(currencyType));
    }

    public LiveData<Status> status() {
        return _status;
    }

    private void requestCard() {
        Call<Card> cardPropertyCall = CardApiService.getInstance().getJSONCardApi().getCardProperty();
        callService(cardPropertyCall, _card);
    }

    private void requestExchange() {
        Call<ExchangeRate> exchangeRatesPropertyCall = ExchangeRatesApiService.getInstance().getJSONRatesApi().getExchangeRatesProperty();
        callService(exchangeRatesPropertyCall, _exchangeRates);
    }


    private <T> void callService(Call<T> call, final MutableLiveData<T> liveData) {
        _status.setValue(Status.LOADING);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }

                _status.setValue(Status.DONE);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                _status.setValue(Status.ERROR);
            }
        });
    }
}