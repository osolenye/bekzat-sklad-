package com.example.orderscladinfo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.orderscladinfo.databinding.FragmentHomeBinding;
import com.example.orderscladinfo.models.Order;
import com.example.orderscladinfo.remote_data.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Call<List<Order>> apiCall= RetrofitClient.getInstance().getApi().getAllOrders();
        apiCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    ArrayList<Order> list=(ArrayList<Order>) response.body();
                    adapter=new HomeAdapter(requireActivity(),list);
                    binding.rvMainListAllOrders.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}