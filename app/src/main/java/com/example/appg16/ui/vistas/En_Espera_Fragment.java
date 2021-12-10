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
import com.example.appg16.databinding.FragEnEsperaBinding;
import com.example.appg16.ui.adaptadores.ListAdapterEnEspera;
import com.example.appg16.ui.modelos.ListElementEnEspera;

import java.util.ArrayList;


public class En_Espera_Fragment extends Fragment {

    private FragEnEsperaBinding binding;
    ArrayList<ListElementEnEspera> elements;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);
        binding = FragEnEsperaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //getActivity().setContentView(R.layout.frag_en_espera);
        recyclerView= root.findViewById(R.id.list_rv_pedidos_realizados);


        linearLayoutManager= new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //ArrayList elementos a cargar en el recyclerview en cardview
        elements = new ArrayList<ListElementEnEspera>();
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 1","$20.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 2","$4.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 3","$7.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 4","$2.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 5","$5.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 6","$8.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 7","$3.000","En espera"));
        elements.add(new ListElementEnEspera(R.drawable.ic_pedido, "Pedido 8","$2.000","En espera"));

        ListAdapterEnEspera listAdapter = new ListAdapterEnEspera(getActivity(),elements);
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