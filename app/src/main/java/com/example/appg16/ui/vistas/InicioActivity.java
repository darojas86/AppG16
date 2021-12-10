package com.example.appg16.ui.vistas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appg16.R;
import com.example.appg16.databinding.ActivityHomeBinding;
import com.example.appg16.ui.modelos.ListElementVerificarPedido;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class InicioActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    public static ArrayList<ListElementVerificarPedido> carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Arraylist global para el manejo de productos del pedido
        carrito = new ArrayList<>();

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.realizar_pedidos, R.id.verificar_pedido,R.id.en_espera)
                .build();
        //llamado al fragment home
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}