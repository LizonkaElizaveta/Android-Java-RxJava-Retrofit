package stanevich.elizaveta.exchangerates.overview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import stanevich.elizaveta.exchangerates.R;
import stanevich.elizaveta.exchangerates.databinding.FragmentOverviewBinding;

public class OverviewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final FragmentOverviewBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);


        OverviewViewModel viewModel = ViewModelProviders.of(this).get(OverviewViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        final RecyclerAdapter adapter = new RecyclerAdapter();
        binding.historyList.setAdapter(adapter);

        viewModel.getCardLiveData().observe(this, notifyAdapterObserver(adapter));
        viewModel.getExchangeRateLiveData().observe(this, notifyAdapterObserver(adapter));

        setChangeCurrencyObserver(binding, viewModel);

        return binding.getRoot();
    }

    private void setChangeCurrencyObserver(final FragmentOverviewBinding binding, OverviewViewModel viewModel) {
        viewModel.getCurrentCurrencyType().observe(this, new Observer<CurrencyType>() {
            @Override
            public void onChanged(CurrencyType currencyType) {
                switch (currencyType){
                    case GBP:
                        setStylesForSelectedButton(binding.btnGBP);
                        setStylesForUnSelectedButton(binding.btnRUB);
                        setStylesForUnSelectedButton(binding.btnEUR);

                        break;
                    case EUR:
                        setStylesForUnSelectedButton(binding.btnGBP);
                        setStylesForUnSelectedButton(binding.btnRUB);
                        setStylesForSelectedButton(binding.btnEUR);
                        break;
                    case RUB:
                        setStylesForUnSelectedButton(binding.btnGBP);
                        setStylesForSelectedButton(binding.btnRUB);
                        setStylesForUnSelectedButton(binding.btnEUR);
                        break;
                }
            }
        });
    }

    private <T> Observer<T> notifyAdapterObserver(final RecyclerAdapter adapter) {
        return new Observer<T>() {
            @Override
            public void onChanged(T data) {
                adapter.notifyDataSetChanged();
            }
        };
    }

    private void setStylesForSelectedButton(Button button){
        button.setTextColor(getResources().getColor(R.color.colorPrimaryDark, null));
        button.setBackground(getResources().getDrawable(R.drawable.background_round_selected, null));
    }

    private void setStylesForUnSelectedButton(Button button){
        button.setTextColor(getResources().getColor(R.color.colorAccent, null));
        button.setBackground(getResources().getDrawable(R.drawable.background_round, null));
    }
}
