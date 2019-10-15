package stanevich.elizaveta.exchangerates.network.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import stanevich.elizaveta.exchangerates.network.data.card.Card;

public class CardApiService {

    private static CardApiService mInstance;
    private static final String BASE_URL = "https://peterpartner.net/tasktest/";
    private Retrofit mRetrofit;

    private CardApiService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CardApiService getInstance() {
        if (mInstance == null) {
            mInstance = new CardApiService();
        }
        return mInstance;
    }


    public interface JSONPCardApi {
        @GET("data.php")
        Call<Card> getCardProperty();
    }

    public JSONPCardApi getJSONCardApi() {
        return mRetrofit.create(JSONPCardApi.class);
    }

}
