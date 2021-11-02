package com.idnp.lab06_idnp_sp.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.idnp.lab06_idnp_sp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private SharedPreferences s1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        obtenerSharedPreferences();
        final TextView textView = binding.textHome;
        final TextView textView2 = binding.textCorreo;
        final TextView textView3 = binding.textDni;
        //pruebas
        //edit_name = (EditText)findViewById(R.id.nombre);
        //SharedPreferences s1 = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        //textView.setText(s1.getString("name","")); --> no funciona
        //edit_name.setText(s1.getString("name","")); --> no funciona
        /*-------------------------------------------------------------------------------*/
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //cambio textview con sharedPref
                textView.setText(s1.getString("name",""));
                textView2.setText(s1.getString("email",""));
                textView3.setText(s1.getString("dni",""));
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public SharedPreferences obtenerSharedPreferences(){
        s1 = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        return s1;
    }
}