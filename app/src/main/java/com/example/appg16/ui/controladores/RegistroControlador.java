package com.example.appg16.ui.controladores;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.appg16.ui.MainActivity;
import com.example.appg16.ui.modelos.ConstanstesFirebase;
import com.example.appg16.ui.modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

public class RegistroControlador {
    public static void registro(Context contexto, String nombre, String correo, String clave) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            usuarioFirestore(contexto, nombre, correo);
                        }else{
                            Toast.makeText(contexto,"Error al intentar registrar el usuario",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    //Creacion del usuario en Firebase
    private static void usuarioFirestore(Context contexto, String nombre, String correo) {
        try {
            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            String id=firebaseUser.getUid();

            long tiempoCreado=firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario=new Usuario(id,nombre,correo,tiempoCreado);

            FirebaseFirestore.getInstance()
            .collection(ConstanstesFirebase.USUARIOS)
            .document(id)
            .set(usuario, SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent= new Intent(contexto, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                contexto.startActivity(intent);
                            }else{
                                Toast.makeText(contexto,"Error al intentar guardar datos del usuario",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
