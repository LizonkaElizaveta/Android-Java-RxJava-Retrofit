package stanevich.elizaveta.exchangerates.overview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import stanevich.elizaveta.exchangerates.databinding.ListViewItemBinding;
import stanevich.elizaveta.exchangerates.model.card.TransactionHistory;

public class RecyclerAdapter extends ListAdapter<TransactionHistory, RecyclerAdapter.RecyclerViewHolder> {

    static class DiffCallback extends DiffUtil.ItemCallback<TransactionHistory> {
        @Override
        public boolean areItemsTheSame(@NonNull TransactionHistory oldItem, @NonNull TransactionHistory newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TransactionHistory oldItem, @NonNull TransactionHistory newItem) {
            return oldItem.equals(newItem);
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ListViewItemBinding binding;

        public RecyclerViewHolder(ListViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TransactionHistory transactionHistory) {
            binding.setViewModel(transactionHistory);
            binding.executePendingBindings();
        }
    }

    public RecyclerAdapter() {
        super(new DiffCallback());
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        TransactionHistory transactionHistory = getItem(position);
        holder.bind(transactionHistory);
    }

}
