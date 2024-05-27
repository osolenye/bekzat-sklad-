package com.example.orderscladinfo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderscladinfo.databinding.ItemOrderBinding;
import com.example.orderscladinfo.models.Order;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ItemOrderBinding binding;
    Context context;
    ArrayList<Order> list = new ArrayList<Order>();

    public HomeAdapter(Context context,ArrayList<Order> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderBinding binding;
        public ViewHolder(@NonNull ItemOrderBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Order order) {
            binding.nameProductCard.setText(order.getNameProduct());
            binding.priceCard.setText(order.getPriceProduct());
            binding.nameUser.setText(order.getNameUser());
            binding.addressUser.setText(order.getAddressUser());
            binding.productsCounter.setText(String.valueOf(order.getCounterProduct()));
            Picasso.get().load(order.getModelImage()).into(binding.imageCard);
        }
    }
}