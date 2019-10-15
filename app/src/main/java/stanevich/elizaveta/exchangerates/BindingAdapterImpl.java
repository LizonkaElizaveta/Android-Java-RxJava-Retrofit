package stanevich.elizaveta.exchangerates;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import stanevich.elizaveta.exchangerates.model.card.TransactionHistory;
import stanevich.elizaveta.exchangerates.overview.RecyclerAdapter;
import stanevich.elizaveta.exchangerates.overview.Status;

public class BindingAdapterImpl {

    @BindingAdapter("listData")
    public static void bindRecyclerView(RecyclerView recyclerView, List<TransactionHistory> data) {
        RecyclerAdapter adapter = (RecyclerAdapter) recyclerView.getAdapter();
        if (adapter != null && data != null)
            adapter.submitList(data);
    }

    @BindingAdapter("imgUrl")
    public static void bindImage(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext())
                .load(imgUrl)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                        .transform(new CenterInside()).transform(new RoundedCorners(30)))
                .into(imageView);

    }

    @BindingAdapter("status")
    public static void bindStatus(ProgressBar progressBar, Status status) {
        switch (status) {
            case LOADING:
                progressBar.setVisibility(View.VISIBLE);
                break;
            case DONE:
                progressBar.setVisibility(View.GONE);
                break;
            case ERROR:
                progressBar.setVisibility(View.GONE);
                break;
        }
    }

    @BindingAdapter("errorImage")
    public static void bindErrorImage(ImageView statusErrorImage, Status status) {
        if (status.equals(Status.ERROR)) {
            statusErrorImage.setVisibility(View.VISIBLE);
            Glide.with(statusErrorImage).load(R.drawable.ic_error_black).into(statusErrorImage);
        }
    }

}
