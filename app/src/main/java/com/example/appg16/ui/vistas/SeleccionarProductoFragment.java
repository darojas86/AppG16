package com.example.appg16.ui.vistas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appg16.R;
import com.example.appg16.databinding.FragSeleccionarProductosBinding;
import com.example.appg16.ui.adaptadores.ListAdapterSeleccionarProducto;
import com.example.appg16.ui.modelos.ListElementSeleccionarProducto;

import java.util.ArrayList;


public class SeleccionarProductoFragment extends Fragment {

    private FragSeleccionarProductosBinding binding;
    ArrayList<ListElementSeleccionarProducto> elements;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragSeleccionarProductosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView= root.findViewById(R.id.list_rv_seleccionar_productos);


        linearLayoutManager= new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //ArrayList elementos a cargar en el recyclerview en cardview
        elements = new ArrayList<ListElementSeleccionarProducto>();
        elements.add(new ListElementSeleccionarProducto(R.drawable.tabla_chocohelado, "Chocohelado","$5.000",R.drawable.ic_agregar_producto));
        elements.add(new ListElementSeleccionarProducto(R.drawable.tabla_malteada1, "Sensasion","$4.000",R.drawable.ic_agregar_producto));
        elements.add(new ListElementSeleccionarProducto(R.drawable.tabla_malteada_2, "Malteada","$3.000",R.drawable.ic_agregar_producto));
        elements.add(new ListElementSeleccionarProducto(R.drawable.tabla_salpicon, "Salpicon","$2.000",R.drawable.ic_agregar_producto));
        elements.add(new ListElementSeleccionarProducto(R.drawable.tabla_ensalada, "Ensalada de fruta","$5.000",R.drawable.ic_agregar_producto));

        ListAdapterSeleccionarProducto listAdapter = new ListAdapterSeleccionarProducto(getActivity(),elements);
        //Llamado al adaptador
        recyclerView.setAdapter(listAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}