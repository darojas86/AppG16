package com.example.appg16.ui.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appg16.R;
import com.example.appg16.ui.modelos.ListElementEnEspera;

import java.util.ArrayList;

public class ListAdapterEnEspera extends RecyclerView.Adapter<ListAdapterEnEspera.ViewHolder> {

    private Activity contexto;
    private ArrayList<ListElementEnEspera> pojo;

    public ListAdapterEnEspera(Activity contexto, ArrayList<ListElementEnEspera> pojo) {
        //this.contexto = contexto;
        this.pojo = pojo;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_pedidos_realizados, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        final ListElementEnEspera ListElementEnEspera= pojo.get(position);
        holder.iv_pedidos_realizados.setImageResource(ListElementEnEspera.getImagen());
        holder.tv_pedidos_realizados1.setText(ListElementEnEspera.getNombre());
        holder.tv_pedidos_realizados2.setText(ListElementEnEspera.getPrecio());
        holder.tv_pedidos_realizados3.setText(ListElementEnEspera.getAgregar());
    }

    @Override
    public int getItemCount(){ return pojo.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_pedidos_realizados;
        private TextView tv_pedidos_realizados1, tv_pedidos_realizados2,tv_pedidos_realizados3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_pedidos_realizados= itemView.findViewById(R.id.iv_pedidos_realizados);
            tv_pedidos_realizados1= itemView.findViewById(R.id.tv_pedidos_realizados1);
            tv_pedidos_realizados2= itemView.findViewById(R.id.tv_pedidos_realizados2);
            tv_pedidos_realizados3= itemView.findViewById(R.id.tv_pedidos_realizados3);
        }
    }


}




















