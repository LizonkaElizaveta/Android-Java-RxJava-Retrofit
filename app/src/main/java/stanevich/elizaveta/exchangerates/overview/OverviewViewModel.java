package stanevich.elizaveta.exchangerates.overview;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stanevich.elizaveta.exchangerates.network.data.card.Card;
import stanevich.elizaveta.exchangerates.network.service.CardApiService;


public class OverviewViewModel extends ViewModel {


    private final MutableLiveData<Card> _card = new MutableLiveData<>();
    private final MutableLiveData<Status> _status = new MutableLiveData<>();


    public OverviewViewModel() {
        requestCard();
    }

    public LiveData<Card> getCardLiveData() {
        return _card;
    }

    public LiveData<Status> status() {
        return _status;
    }

    public void requestCard() {
        _status.setValue(Status.LOADING);
        CardApiService.getInstance().getJSONCardApi().getCardProperty().enqueue(new Callback<Card>() {

            @Override
            public void onResponse(Call<Card> call, Response<Card> response) {

                if (response.isSuccessful()) {
                    final Card card = response.body();

                    _card.setValue(card);
                }

                _status.setValue(Status.DONE);
            }

            @Override
            public void onFailure(Call<Card> call, Throwable t) {
                _status.setValue(Status.ERROR);
                _card.setValue(new Card());
            }
        });
    }

}