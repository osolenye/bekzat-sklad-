package com.example.orderscladinfo.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderscladinfo.databinding.ItemUserBinding;
import com.example.orderscladinfo.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ItemUserBinding binding;
    ArrayList<User> list=new ArrayList<>();
    Context context;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;
        public ViewHolder(@NonNull ItemUserBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }

        public void onBind(User user) {
            binding.nameUser.setText(user.getName());
            binding.emailUser.setText(user.getEmail());
        }
    }
}
