package stanevich.elizaveta.exchangerates;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import stanevich.elizaveta.exchangerates.network.data.card.TransactionHistory;
import stanevich.elizaveta.exchangerates.overview.RecyclerAdapter;

public class BindingAdapterImpl {

    @BindingAdapter("listData")
    public static void bindRecyclerView(RecyclerView recyclerView, List<TransactionHistory> data) {
        RecyclerAdapter adapter = (RecyclerAdapter) recyclerView.getAdapter();
        if (adapter != null && data != null)
        adapter.submitList(data);
    }

    @BindingAdapter("imgUrl")
    public static void bindImage(ImageView imageView, String imgUrl){
        Glide.with(imageView.getContext())
                .load(imgUrl)
                .apply(new RequestOptions().transform(new CenterInside()).transform(new RoundedCorners(30)))
                .into(imageView);

    }
}


