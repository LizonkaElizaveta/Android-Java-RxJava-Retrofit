package stanevich.elizaveta.exchangerates.network.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import stanevich.elizaveta.exchangerates.network.data.rates.ExchangeRates;

public class ExchangeRatesApiService {
    private static ExchangeRatesApiService mInstance;
    private static final String BASE_URL = "https://www.cbr-xml-daily.ru";
    private Retrofit mRetrofit;

    private ExchangeRatesApiService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ExchangeRatesApiService getInstance() {
        if (mInstance == null) {
            mInstance = new ExchangeRatesApiService();
        }
        return mInstance;
    }


    public interface JSONPRatesApi {
        @GET("/daily_json.js")
        Call<ExchangeRates> getExchangeRatesProperty();
    }

    public JSONPRatesApi getJSONRatesApi() {
        return mRetrofit.create(JSONPRatesApi.class);
    }

}
