package com.example.appg16.ui.controladores;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarContraControlador {
    public static void recuperar(Activity activity, String correo) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(correo)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            activity.finish();
                            Toast.makeText(activity,"Verifica tu correo electronico",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(activity,"Error al intentar recuperar contraseña",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
