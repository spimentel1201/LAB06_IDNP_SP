package com.idnp.lab06_idnp_sp.ui.home;

import android.content.Intent;
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

import com.idnp.lab06_idnp_sp.MainActivity;
import com.idnp.lab06_idnp_sp.SharedPefManager;
import com.idnp.lab06_idnp_sp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView textView2 = binding.textCorreo;
        final TextView textView3 = binding.textDni;

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //cambio textview con sharedPref
                textView.setText(SharedPefManager.read(SharedPefManager.NAME, null));
                textView2.setText(SharedPefManager.read(SharedPefManager.EMAIL, null));
                textView3.setText(SharedPefManager.read(SharedPefManager.DNI, null));
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void CerrarSesion(View view){
        SharedPefManager.borrarPreferencias();
        Intent i = new Intent(this.getActivity(), MainActivity.class);
        startActivity(i);
    }
}