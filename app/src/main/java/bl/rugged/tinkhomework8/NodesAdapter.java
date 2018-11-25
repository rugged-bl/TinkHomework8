package bl.rugged.tinkhomework8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NodesAdapter extends RecyclerView.Adapter<NodesAdapter.CoinsViewHolder> {

    private List<Node> items = new ArrayList<>();

    private OnItemClickListener listener;

    NodesAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_node, parent, false);
        return new CoinsViewHolder(layout, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Node> newItems) {
        items = newItems;
        notifyDataSetChanged();
    }

    static class CoinsViewHolder extends RecyclerView.ViewHolder {
        OnItemClickListener listener;
        TextView tvNodeValue;

        CoinsViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvNodeValue = itemView.findViewById(R.id.tvValue);
        }

        void bind(Node node) {
            itemView.setOnClickListener(view -> listener.onClick(node));
            tvNodeValue.setText(String.valueOf(node.getValue()));
        }
    }

    interface OnItemClickListener {
        void onClick(Node coinInfo);
    }
}
