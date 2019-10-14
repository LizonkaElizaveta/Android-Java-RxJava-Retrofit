package stanevich.elizaveta.exchangerates.overview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import stanevich.elizaveta.exchangerates.R;
import stanevich.elizaveta.exchangerates.databinding.FragmentOverviewBinding;

public class OverviewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FragmentOverviewBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview,container,false);


        return binding.getRoot();
    }
}
