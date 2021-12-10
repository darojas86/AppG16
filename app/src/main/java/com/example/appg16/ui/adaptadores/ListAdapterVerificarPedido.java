package com.example.appg16.ui.adaptadores;

import static com.example.appg16.ui.vistas.InicioActivity.carrito;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appg16.R;
import com.example.appg16.ui.modelos.ListElementVerificarPedido;

import java.util.ArrayList;

public class ListAdapterVerificarPedido extends RecyclerView.Adapter<ListAdapterVerificarPedido.ViewHolder>
        {

    private ArrayList<ListElementVerificarPedido> pojo;
    private View.OnClickListener listener;

    public ListAdapterVerificarPedido(ArrayList<ListElementVerificarPedido> pojo) {
        this.pojo = pojo;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_verificar_pedido, parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        //view.setOnClickListener(this);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_verificar_pedido1.setImageResource(pojo.get(position).getImagen());
        holder.tv_verificar_pedido1.setText(pojo.get(position).getNombre());
        holder.tv_verificar_pedido2.setText(pojo.get(position).getPrecio());
        holder.tv_verificar_pedido4.setText(pojo.get(position).getCantidad());
        holder.iv_verificar_pedido2.setImageResource(pojo.get(position).getEliminar());


        int finalPosition = position;
        holder.iv_verificar_pedido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mTextView = holder.tv_verificar_pedido1.findViewById(R.id.tv_verificar_pedido1);
                //mTextView.setText(R.string.napping);

                PopupMenu popupMenu= new PopupMenu(v.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_eliminar,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.eliminar:
                                carrito.remove(finalPosition);
                                Navigation.findNavController(v).navigate(R.id.verificar_pedido);
                                Toast.makeText(v.getContext(), "Producto eliminado",Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojo.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_verificar_pedido1,iv_verificar_pedido2;
        private TextView tv_verificar_pedido1, tv_verificar_pedido2,tv_verificar_pedido4,tv_total;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_verificar_pedido1= itemView.findViewById(R.id.iv_verificar_pedido1);
            iv_verificar_pedido2= itemView.findViewById(R.id.iv_verificar_pedido2);
            tv_verificar_pedido1= itemView.findViewById(R.id.tv_verificar_pedido1);
            tv_verificar_pedido2= itemView.findViewById(R.id.tv_verificar_pedido2);
            tv_verificar_pedido4= itemView.findViewById(R.id.tv_verificar_pedido4);
            tv_total=itemView.findViewById(R.id.tv_total);

        }




    }
}
