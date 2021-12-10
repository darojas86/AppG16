package com.example.appg16.ui.adaptadores;

import static com.example.appg16.ui.vistas.InicioActivity.carrito;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appg16.R;
import com.example.appg16.ui.modelos.ListElementVerificarPedido;
import com.example.appg16.ui.modelos.ListElementSeleccionarProducto;

import java.util.ArrayList;

public class ListAdapterSeleccionarProducto extends RecyclerView.Adapter<ListAdapterSeleccionarProducto.ViewHolder>{

    private ArrayList<ListElementSeleccionarProducto> pojo;
    private Activity contexto;


    public ListAdapterSeleccionarProducto(Activity contexto, ArrayList<ListElementSeleccionarProducto> pojo) {
        this.contexto = contexto;
        this.pojo = pojo;
    }

    @NonNull
    @Override
        public ListAdapterSeleccionarProducto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_seleccionar_productos, parent,false);
        ListAdapterSeleccionarProducto.ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListElementSeleccionarProducto ListElementSeleccionarProducto= pojo.get(position);

        holder.iv_seleccionar_productos1.setImageResource(ListElementSeleccionarProducto.getImagen_producto());
        holder.tv_seleccionar_productos1.setText(ListElementSeleccionarProducto.getNombre());
        holder.tv_seleccionar_productos2.setText(ListElementSeleccionarProducto.getPrecio());
        holder.iv_seleccionar_productos2.setImageResource(ListElementSeleccionarProducto.getAgregar());
        //Evento agregar al pedido
        holder.iv_seleccionar_productos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ArrayList elementos a cargar en el recyclerview en cardview

                carrito.add(new ListElementVerificarPedido(ListElementSeleccionarProducto.getImagen_producto(),
                        ListElementSeleccionarProducto.getNombre(),
                        ListElementSeleccionarProducto.getPrecio(),
                        "1",
                        R.drawable.ic_eliminar));
                Toast.makeText(contexto.getApplicationContext(), "Producto agregado",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojo.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_seleccionar_productos1,iv_seleccionar_productos2;
        private TextView tv_seleccionar_productos1, tv_seleccionar_productos2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_seleccionar_productos1= itemView.findViewById(R.id.iv_seleccionar_productos1);
            tv_seleccionar_productos1= itemView.findViewById(R.id.tv_seleccionar_productos1);
            tv_seleccionar_productos2= itemView.findViewById(R.id.tv_seleccionar_productos2);
            iv_seleccionar_productos2= itemView.findViewById(R.id.iv_seleccionar_productos2);
        }
    }
}
