package com.example.appg16.ui.vistas;

import static com.example.appg16.ui.vistas.InicioActivity.carrito;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appg16.R;
import com.example.appg16.databinding.FragVerificarPedidoBinding;
import com.example.appg16.ui.adaptadores.ListAdapterVerificarPedido;


public class verificar_pedidoFragment extends Fragment {

   // private NotificationsViewModel notificationsViewModel;
    private @NonNull FragVerificarPedidoBinding binding;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TextView mTextView;
    private Button boton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragVerificarPedidoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        boton= view.findViewById(R.id.b_verificar_pedido);
        recyclerView= view.findViewById(R.id.list_rv_verificar_pedido);
        linearLayoutManager= new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        //carrito es la variable global creada en el activity principal de los fragment
        ListAdapterVerificarPedido listAdapter = new ListAdapterVerificarPedido(carrito);
        //Llamado al adaptador
        recyclerView.setAdapter(listAdapter);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Producto eliminado",Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigate(R.id.verificar_pedido);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}